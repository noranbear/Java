
package app;

import java.util.ArrayList;
import java.util.Scanner;

import dao.TodoDAO;
import frame.DAO;
import frame.Search;
import vo.TodoVO;

/**
 * To do list application
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. ���� 11:22:14
 */
public class App {

	public static void main(String[] args) {
		System.out.println("Start...");
		
		TodoDAO toDo = new TodoDAO();
		// �� �κ��� ������ TodoDAO�� App�� �� �޶�پ� �ִ°�
		DAO<String, TodoVO> dao = toDo;	//Generic �ǰ��� type. 
		Search<TodoVO, Boolean> search = toDo;
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Input cmd(i,d,r,u,s,a,f,q): ");		
			String cmd = sc.next();							
			
			// q: �޴����� ������
			if(cmd.equals("q")) {				
				System.out.println("\nQuit");
				break;
			
			// i: ���� ��� ����
			}else if(cmd.equals("i")) {
				// 1. ������ �޴´�.
				System.out.println("Write a To-do list.\n");
				
				System.out.println("Write a list number: ");
				String num = sc.next();
				// ����Ʈ �ѹ��� ���ڷ� �� �� ���
				try {
					Integer.parseInt(num);
				}catch(Exception e) {
					System.out.println("Type only numbers.\n");
					continue;
				}
				System.out.println("Write date: ");
				String when = sc.next();
				System.out.println("Write what to do: ");
				String what = sc.next();
				
				// 2. ������ ��ü�� ��´�.
				TodoVO d = new TodoVO(num, when, what);
				
				// 3. ������ ������ �����Ѵ�.
				try {
					dao.insert(d);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
			
			// d: �� �� ��� �����
			}else if(cmd.equals("d")) {
				// 1. ����Ʈ �ѹ��� �޴´�.
				System.out.println("Write the order: ");
				String num = sc.next();
				// ����Ʈ �ѹ��� ���ڷ� �� �� ���
				try {
					Integer.parseInt(num);
				}catch(Exception e) {
					System.out.println("Type only numbers.\n");
					continue;
				}
				
				// 2. �ش� ����Ʈ�� �����.
				try {
					dao.delete(num);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
				
			 //r: �޼��� ��� ����� �����.
			}else if(cmd.equals("r")) {
				try {
					dao.delete();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
				
			// u: ������ ������Ʈ�Ѵ�. True False (Exception 1)??
			}else if(cmd.equals("u")) {
				System.out.println("Opt done.");
				System.out.println("Inpute the order: ");
				String num = sc.next();
			
				// ������ �ٲ�.
				try {
					dao.update(num);
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				System.out.println();
				
			// s: ������ �ҷ�����.	(Exception �Ϸ�)
			}else if(cmd.equals("s")) {
				System.out.println("Input the order: ");
				String num = sc.next();
				
				TodoVO o = null;
				try {
					o = dao.select(num);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println(o);
				System.out.println();
				
			// a: DB�� �ִ� ��� ������ �ҷ�����. (Exception �Ϸ�)
			}else if(cmd.equals("a")) {
				ArrayList<TodoVO> a = new ArrayList<TodoVO>();
				try {
					a = dao.select();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				for (TodoVO d : a) {
					System.out.println(d);
				}
				System.out.println();
			
			// f: ������ �Ϸ������� ���� ��� ����� �����ش�.
			}else if(cmd.equals("f")) {
				System.out.println("Done or Ongoing lists(true/false): ");
				String check = sc.next();
				
				// input�� true or false�� �ƴ� ���
				if(!(check.equals("true")) && !(check.equals("false"))) {
					System.out.println("Type only 'true' or 'false'.\n");
					continue;
				}
				
				boolean done = Boolean.parseBoolean(check);
				
				ArrayList<TodoVO> a = new ArrayList<TodoVO>();
				// ������ ����.
				try {
					a = search.search(done);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				// ������ ����Ʈ�� �����ش�.
				for (TodoVO o : a) {
					System.out.println(o);
				}
				System.out.println();
				
			}else {
				// �޴� ���� input�� ������ ��
				System.out.println("Select a menu.\n");
				continue;
			}
		}
		sc.close();
		System.out.println("End...");

	}

}
