/**
 * 
 */
package ws;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. 오전 11:22:14
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
			
			// i: 정보를 넣어서 보낸다.
			}else if(cmd.equals("i")) {
				System.out.println("Write a To-do list.");
				
				System.out.println("Write an order: ");
				String num = sc.next();
				System.out.println("Write when: ");
				String when = sc.next();
				System.out.println("Write what: ");
				String what = sc.next();
				
				// 정보를 담음.
				TodoVO d = new TodoVO(num, when, what);
				// 정보를 보냄.
				dao.insert(d);
			
			// d: 정보를 지운다.
				///?? not done만?
			}else if(cmd.equals("d")) {
				System.out.println("Write the order: ");
				String num = sc.next();
				
				dao.delete(num);
			
			// u: 정보를 업데이트한다.
				// done or not ????
			}else if(cmd.equals("u")) {
				System.out.println("Opt done.");
				
				System.out.println("Write an order: ");
				String num = sc.next();
				System.out.println("Write when: ");
				String when = sc.next();
				System.out.println("Write what: ");
				String what = sc.next();
				
				// 정보를 담음.
				TodoVO d = new TodoVO(num, when, what);
				// 정보를 바꿈.
				dao.update(d);
				
			// s: 정보를 불러낸다.	
			}else if(cmd.equals("s")) {
				System.out.println("Inpute the order: ");
				String num = sc.next();
				
				TodoVO o = dao.select(num);
				System.out.println(o);
				
			// a: DB에 있는 모든 정보를 불러낸다.
			}else if(cmd.equals("a")) {
				ArrayList<TodoVO> a = dao.select();
				
				for (TodoVO d : a) {
					System.out.println(d);
				}
				
			}else {
				// 메뉴 외의 input이 들어왔을 때
				System.out.println("Select a menu.\n");
				continue;
			}
		}
		sc.close();
		System.out.println("End...");

	}

}
