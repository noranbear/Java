/**
 * 
 */
package ws;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 유저와 상호작용할 TodoList application 
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. 오전 11:22:14
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
			}else if(cmd.equals("d")) {
				System.out.println("Write the order: ");
				String num = sc.next();
				
				dao.delete(num);
			
			// u: 정보를 업데이트한다. True False
			}else if(cmd.equals("u")) {
				System.out.println("Opt done.");
				System.out.println("Inpute the order: ");
				String num = sc.next();
			
				// 정보를 바꿈.
				dao.update(num);
				
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
			
			// f: Show ongoing lists or done lists
			}else if(cmd.equals("f")) {
				// search()의 결과물 ArrayList<TodoVo>를 받을 객체를 만든다.
				ArrayList<TodoVO> a = new ArrayList<TodoVO>();
				System.out.println("Done or Ongoing lists(true/false): ");
				String check = sc.next();
				boolean done = Boolean.parseBoolean(check);

				// 정보를 보내서 ArrayList에 담음.
				a = search.search(done);
				
				// ArrayList 안의 정보를 보여줌.
				for (TodoVO o : a) {
					System.out.println(o);
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
