/**
 * 
 */
package ws;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. ���� 11:22:14
 */
public class App {

	public static void main(String[] args) {
		System.out.println("Start...");
		DAO dao = new TodoDAO();	
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Input cmd(i,d,u,s,a,q): ");		
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
				///?? not done��?
			}else if(cmd.equals("d")) {
				System.out.println("Write the order: ");
				String num = sc.next();
				
				dao.delete(num);
			
			// u: ������ ������Ʈ�Ѵ�.
				// done or not ????
			}else if(cmd.equals("u")) {
				System.out.println("Opt done.");
				
				System.out.println("Write an order: ");
				String num = sc.next();
				System.out.println("Write when: ");
				String when = sc.next();
				System.out.println("Write what: ");
				String what = sc.next();
				
				// ������ ����.
				TodoVO d = new TodoVO(num, when, what);
				// ������ �ٲ�.
				dao.update(d);
				
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
