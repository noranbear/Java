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
 * App���� �� UI ����
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 27. ���� 10:03:50
 * @version 1.0
 */
public class UI {
	
	// �����ͺ��̽� ����
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
	
	List list; //list2;		// awt�� �ִ� list
	
	
	// Constructor
	public UI() {
		dao = new BookDao();	// �����ͺ��̽� ����
		init();
		make();
		addEvent();
	}
	/**
	 * ����� ������Ʈ ����
	 */
	public void init() {
		// ����
		f = new Frame("Search Book");
		
		b1 = new Button("Enter");
		b2 = new Button("All");
		b3 = new Button("�뿩");
		b4 = new Button("�ݳ�");
		
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
	 * UI �����
	 */
	public void make() {
		
		// Title
		title = new Label("Search By Book ID", Label.CENTER);
		title.setBackground(Color.orange);
		f.add(title, BorderLayout.NORTH);
		
		// �÷� ����
		pe1.setBackground(Color.LIGHT_GRAY);	// edge panels-> grey
		pe2.setBackground(Color.LIGHT_GRAY);
		pe3.setBackground(Color.LIGHT_GRAY);

		pt.setBackground(Color.getHSBColor(10, 50, 100));	// top field -> yellow
		pb2.setBackground(Color.getHSBColor(10, 50, 100));

		
		// center panel�� ���η� 3���
		pc.setLayout(new GridLayout(3, 1));
		pt.setLayout(new GridLayout(3, 1));
		
		// main�� edge �����
		main.setLayout(new BorderLayout());
		main.add(pe1,"North");
		main.add(pe2,"East");
		main.add(pe3,"West");
		main.add(mainT,"South");
		
		// main ������� �г� �ֱ�
		main.add(pc,"Center");
		// Top
		pc.add(pt);
		pt.add(pt1);	
		pt.add(pt2);
		
		// ä��â�� ��ư
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
		
		// ��ư
		pb.add(pb2);
		pb2.add(b3);
		pb2.add(b4);
		
	
		// main�� frame�� ���̱�
		f.add(main,"Center");
		
		// frame ���̰� �ϱ�
		f.setSize(500, 400);
		f.setVisible(true);
		
		
		
	}
	
	public void addEvent() {
		
		f.addWindowListener(new WindowAdapter() {
			/**
			 * frame ����
			 */
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		/**
		 * Enter button�� ������ select 
		 */
		b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// �����Է�
				try {
					list.removeAll();
					int id = Integer.parseInt(t1.getText());
					t1.setText("");
					BookVo b = null;
					b = dao.select(id);
					String ss;
					if(b.getStatus() == 0) {
						ss = "�뿩��";
					}else {
						ss = "�뿩����";
					}
					mainT.setText("'" + b.getTitle() + "'��/�� "+ ss + "�Դϴ�.");
					String s = b.getId()+" / "+b.getTitle()+" / "+b.getAuthor()+" / "+ss;
					list.add(s);
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
		
			}
		});
		
		/**
		 * All button�� ������ selectAll
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
							ss = "�뿩��";
						}else {
							ss = "�뿩����";
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
		 * �뿩 update0
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
					mainT.setText("'" + b.getTitle() + "'��/�� �뿩�ϼ̽��ϴ�.");
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		
		});
		
		/**
		 * �ݳ� update1
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
					mainT.setText("'" + b.getTitle() + "'�� �ݳ��ϼ̽��ϴ�.");
					
				} catch (Exception e1) {
					
					e1.printStackTrace();
				}
				
			}
		
		});
		

	}
}
