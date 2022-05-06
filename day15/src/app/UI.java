package app;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import dao.BookDao;
import frame.Dao;
import vo.BookVo;


/**
 * App에서 쓸 UI 설계
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 27. 오전 10:03:50
 * @version 1.0
 */
public class UI {
	
	// 데이터베이스 연동
	Dao<Integer, BookVo> dao;
	java.util.List<BookVo> blist;

	Frame f;
	Label title;
	
	Panel pe1, pe2, pe3;
	Panel main;
	Panel pc; 
	Panel pt, pt1, pt2, pt3;
	Panel pm, pb, pb2;
	
	TextField t1, t2;

	TextField mainT;
	
	Button b1, b2;
	Button b3, b4;
	
	List list; //list2;		// awt에 있는 list
	
	
	// Constructor
	public UI() {
		dao = new BookDao();	// 데이터베이스 연동
		init();
		make();
		addEvent();
	}
	/**
	 * 사용할 컴포넌트 생성
	 */
	public void init() {
		// 생성
		f = new Frame("Search Book");
		
		b1 = new Button("Enter");
		b2 = new Button("All");
		b3 = new Button("대여");
		b4 = new Button("반납");
		
		pe1 = new Panel();			// edge panels
		pe2 = new Panel();
		pe3 = new Panel();
		
		pc = new Panel();			// center panel
		
		pt = new Panel();			// top panel on center panel
		pt1 = new Panel();			// top panel on center panel
		pt2 = new Panel();
		pt3 = new Panel();
		
		pm = new Panel();
		pb = new Panel();
		pb2 = new Panel();
		
		main = new Panel();
		
		t1 = new TextField();
		t2 = new TextField();
		mainT = new TextField();
		list = new List();
//		list2 = new List();
		
	}
	
	/**
	 * UI 만들기
	 */
	public void make() {
		
		// Title
		title = new Label("Search By Book ID", Label.CENTER);
		title.setBackground(Color.orange);
		f.add(title, BorderLayout.NORTH);
		
		// 컬러 설정
		pe1.setBackground(Color.LIGHT_GRAY);	// edge panels-> grey
		pe2.setBackground(Color.LIGHT_GRAY);
		pe3.setBackground(Color.LIGHT_GRAY);

		pt.setBackground(Color.getHSBColor(10, 50, 100));	// top field -> yellow
		pb2.setBackground(Color.getHSBColor(10, 50, 100));

		
		// center panel을 가로로 3등분
		pc.setLayout(new GridLayout(3, 1));
		pt.setLayout(new GridLayout(3, 1));
		
		// main에 edge 만들기
		main.setLayout(new BorderLayout());
		main.add(pe1,"North");
		main.add(pe2,"East");
		main.add(pe3,"West");
		main.add(mainT,"South");
		
		// main 가운데에다 패널 넣기
		main.add(pc,"Center");
		// Top
		pc.add(pt);
		pt.add(pt1);	
		pt.add(pt2);
		
		// 채팅창과 버튼
		pt2.setLayout(new BorderLayout());
		pt2.add(b1,"East");
		pt2.add(t1);
		
		// Middle
		pc.add(pm);
		pm.setLayout(new BorderLayout());
		pm.add(b2, "East");
		pm.add(list);
		
		// Bottom
		pc.add(pb);
		pb.setLayout(new GridLayout(1, 2));
//		pb.add(list2);
		pb.add(t2);
		
		// 버튼
		pb.add(pb2);
		pb2.add(b3);
		pb2.add(b4);
		
	
		// main을 frame에 붙이기
		f.add(main,"Center");
		
		// frame 보이게 하기
		f.setSize(500, 400);
		f.setVisible(true);
		
		
		
	}
	
	public void addEvent() {
		
		f.addWindowListener(new WindowAdapter() {
			/**
			 * frame 종료
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		/**
		 * Enter button을 누르면 select 
		 */
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 정보입력
				try {
					list.removeAll();
					int id = Integer.parseInt(t1.getText());
					t1.setText("");
					BookVo b = null;
					b = dao.select(id);
					String ss;
					if(b.getStatus() == 0) {
						ss = "대여중";
					}else {
						ss = "대여가능";
					}
					mainT.setText("'" + b.getTitle() + "'은/는 "+ ss + "입니다.");
					String s = b.getId()+" / "+b.getTitle()+" / "+b.getAuthor()+" / "+ss;
					list.add(s);
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
		
			}
		});
		
		/**
		 * All button을 누르면 selectAll
		 */
		b2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					mainT.setText("");
					list.removeAll();
					blist = dao.select();
					for (BookVo bl : blist) {
						String ss;
						if(bl.getStatus() == 0) {
							ss = "대여중";
						}else {
							ss = "대여가능";
						}
						String s = bl.getId()+" / "+bl.getTitle()+" / "+bl.getAuthor()+" / "+ss;
						list.add(s);
					}
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		});
		
		/**
		 * 대여 update0
		 */
		b3.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(t2.getText());
					t2.setText("");
					dao.update0(id);
					BookVo b = null;
					b = dao.select(id);
					mainT.setText("'" + b.getTitle() + "'을/를 대여하셨습니다.");
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		
		});
		
		/**
		 * 반납 update1
		 */
		b4.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(t2.getText());
					t2.setText("");
					dao.update1(id);
					BookVo b = null;
					b = dao.select(id);
					mainT.setText("'" + b.getTitle() + "'를 반납하셨습니다.");
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		
		});
		

	}
}
