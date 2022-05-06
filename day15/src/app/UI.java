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
import java.sql.SQLException;

import dao.BookDao;
import frame.Dao;
import vo.BookVo;


/**
 * App에서 쓸 UI 설계
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 27. 오전 10:03:50
 * @version 2.0
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
	
	List list;
	
	
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
		
		main = new Panel();			// main panel
		
		pe1 = new Panel();			// edge panels
		pe2 = new Panel();
		pe3 = new Panel();
		
		pc = new Panel();			// center panel
		
		pt = new Panel();			// top panel on center panel
		pt1 = new Panel();			// top panels on the top panel
		pt2 = new Panel();			
		pt3 = new Panel();			
		
		pm = new Panel();			// middle panel on the center panel
		pb = new Panel();			// bottom panels on the center panel
		pb2 = new Panel();			
		
		t1 = new TextField();
		t2 = new TextField();
		mainT = new TextField();
		list = new List();
		
	}
	
	/**
	 * UI 만들기
	 */
	public void make() {
		
		// Title: "Search By Book ID"
		title = new Label("Search By Book ID", Label.CENTER);
		title.setBackground(Color.orange);
		f.add(title, BorderLayout.NORTH);
		
		// 컬러 설정
		pe1.setBackground(Color.LIGHT_GRAY);	// edge panels-> grey
		pe2.setBackground(Color.LIGHT_GRAY);
		pe3.setBackground(Color.LIGHT_GRAY);

		pt.setBackground(Color.getHSBColor(10, 50, 100));	// top field -> yellow
		pb2.setBackground(Color.getHSBColor(10, 50, 100));  // bottom right field -> yellow

		// Layout 만들기
		pc.setLayout(new GridLayout(3, 1));		// center panel을 가로로 3등분
		pt.setLayout(new GridLayout(3, 1));		// top panel을 가로로 3등분
		
		// main에 edge 만들기
		main.setLayout(new BorderLayout());
		main.add(pe1,"North");
		main.add(pe2,"East");
		main.add(pe3,"West");
		main.add(mainT,"South");
		
		// main 가운데에다 center 패널 넣기
		main.add(pc,"Center");
		
		// On center panel
		// Top
		pc.add(pt);
		pt.add(pt1);	
		pt.add(pt2);
		// 검색창과 버튼
		pt2.setLayout(new BorderLayout());
		pt2.add(b1,"East");
		pt2.add(t1);
		
		// Middle
		pc.add(pm);
		pm.setLayout(new BorderLayout());
		// 리스트와 버튼
		pm.add(b2, "East");
		pm.add(list);
		
		// Bottom
		pc.add(pb);
		pb.setLayout(new GridLayout(1, 2));
		// 검색창과 버튼
		pb.add(t2);
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
		/**
		 * Frame
		 */
		f.addWindowListener(new WindowAdapter() {
			/**
			 * x 누르면 종료
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		/**
		 * Enter button
		 */
		b1.addActionListener(new ActionListener() {
			/**
			 * Book ID를 t1에 쓰고 버튼을 누르면 해당 책이 검색된다.
			 * selectOne 
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				// 정보입력
				try {
					list.removeAll();
					int id = Integer.parseInt(t1.getText());
					t1.setText("");
					
					BookVo b = null;
					b = dao.select(id);
					
					// mainT와 list 메세지 세팅
					String ss;
					if(b.getStatus() == 0) {
						ss = "대여중";
					}else {
						ss = "대여가능";
					}
					mainT.setText("'" + b.getTitle() + "'은/는 "+ ss + "입니다.");
					String s = b.getId()+" / "+b.getTitle()+" / "+b.getAuthor()+" / "+ss;
					list.add(s);
					
				}catch (SQLException e2) {
					mainT.setText(e2.getMessage());
				// IF: 정수(id 타입)가 아닌 값이 들어온 경우
				}catch (NumberFormatException e3) {
					mainT.setText("다시 입력하십시오.");
					t1.setText("");
				}
		
			}
		});
		/**
		 * All button
		 */
		b2.addActionListener(new ActionListener() {
			/**
			 * 모든 책들의 정보를 보여준다
			 * selectAll
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					mainT.setText("");
					list.removeAll();
					blist = dao.select();
					
					// list 메세지 세팅
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
					mainT.setText(e1.getMessage());
				}
				
			}
		});
		/**
		 * 대여 버튼
		 */
		b3.addActionListener(new ActionListener() {
			/**
			 * 선택된 책을 대여한다.
			 * update0
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(t2.getText());
					t2.setText("");
					dao.update0(id);
					BookVo b = null;
					b = dao.select(id);
					// IF: 이미 책이 대여되어 있는 경우
					if(b.getStatus() == '0') {
						mainT.setText("'" + b.getTitle() + "'은/는 현재 대여불가합니다.");
					}else {
						mainT.setText("'" + b.getTitle() + "'을/를 대여하셨습니다.");
					}
				} catch (SQLException e1) {
					mainT.setText(e1.getMessage());
				// IF: 정수(id 타입)가 아닌 값이 들어온 경우
				}catch (NumberFormatException e2) {
					mainT.setText("다시 입력하십시오.");
					t2.setText("");
				}
			}
		});
		/**
		 * 반납 버튼
		 */
		b4.addActionListener(new ActionListener() {
			/**
			 * 선택된 책을 반납한다.
			 * update1
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					int id = Integer.parseInt(t2.getText());
					t2.setText("");
					dao.update1(id);
					BookVo b = null;
					b = dao.select(id);
					// IF: 이미 책이 반납되어 있는 경우
					if(b.getStatus() == '1') {
						mainT.setText("'" + b.getTitle() + "'은/는 이미 반납되어 있습니다.");
					}else {
						mainT.setText("'" + b.getTitle() + "'를 반납하셨습니다.");
					}
					
				}catch (SQLException e1) {
					mainT.setText(e1.getMessage());
				// IF: 정수(id 타입)가 아닌 값이 들어온 경우
				}catch (NumberFormatException e2) {
					mainT.setText("다시 입력하십시오.");
					t2.setText("");
				}
			}
		});
		
	}
}
