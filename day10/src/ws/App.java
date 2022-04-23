/**
 * 
 */
package ws;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * ������ ��ȣ�ۿ��� TodoList application 
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. ���� 11:22:14
 */
public class App {

	public static void main(String[] args) {
		System.out.println("Start...");
		
		TodoDAO toDo = new TodoDAO();
		DAO dao = toDo;
		Search search = toDo;
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Input cmd(i,d,u,s,a,f,q): ");		
			String cmd = sc.next();							
			
			if(cmd.equals("q")) {				
				System.out.println("Quit");
				break;
			
			// i: ������ �־ ������.
			}else if(cmd.equals("i")) {
				System.out.println("Write a To-do list.");
				
				System.out.println("Write an order: ");
				String num = sc.next();
				System.out.println("Write when: ");
				String when = sc.next();
				System.out.println("Write what: ");
				String what = sc.next();
				
				// ������ ����.
				TodoVO d = new TodoVO(num, when, what);
				// ������ ����.
				dao.insert(d);
			
			// d: ������ �����.
			}else if(cmd.equals("d")) {
				System.out.println("Write the order: ");
				String num = sc.next();
				
				dao.delete(num);
			
			// u: ������ ������Ʈ�Ѵ�. True False
			}else if(cmd.equals("u")) {
				System.out.println("Opt done.");
				System.out.println("Inpute the order: ");
				String num = sc.next();
			
				// ������ �ٲ�.
				dao.update(num);
				
			// s: ������ �ҷ�����.	
			}else if(cmd.equals("s")) {
				System.out.println("Inpute the order: ");
				String num = sc.next();
				
				TodoVO o = dao.select(num);
				System.out.println(o);
				
			// a: DB�� �ִ� ��� ������ �ҷ�����.
			}else if(cmd.equals("a")) {
				ArrayList<TodoVO> a = dao.select();
				
				for (TodoVO d : a) {
					System.out.println(d);
				}
			
			// f: Show ongoing lists or done lists
			}else if(cmd.equals("f")) {
				// search()�� ����� ArrayList<TodoVo>�� ���� ��ü�� �����.
				ArrayList<TodoVO> a = new ArrayList<TodoVO>();
				System.out.println("Done or Ongoing lists(true/false): ");
				String check = sc.next();
				boolean done = Boolean.parseBoolean(check);

				// ������ ������ ArrayList�� ����.
				a = search.search(done);
				
				// ArrayList ���� ������ ������.
				for (TodoVO o : a) {
					System.out.println(o);
				}
				
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
