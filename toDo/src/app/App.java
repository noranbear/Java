
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
 * @since 2022. 4. 20. 오전 11:22:14
 */
public class App {

	public static void main(String[] args) {
		System.out.println("Start...");
		
		TodoDAO toDo = new TodoDAO();
		// 이 부분이 없으면 TodoDAO랑 App이 딱 달라붙어 있는거
		DAO<String, TodoVO> dao = toDo;	//Generic 되고나서 type. 
		Search<TodoVO, Boolean> search = toDo;
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Input cmd(i,d,r,u,s,a,f,q): ");		
			String cmd = sc.next();							
			
			// q: 메뉴에서 나가기
			if(cmd.equals("q")) {				
				System.out.println("\nQuit");
				break;
			
			// i: 할일 목록 쓰기
			}else if(cmd.equals("i")) {
				// 1. 정보를 받는다.
				System.out.println("Write a To-do list.\n");
				
				System.out.println("Write a list number: ");
				String num = sc.next();
				// 리스트 넘버를 숫자로 안 쓴 경우
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
				
				// 2. 정보를 객체에 담는다.
				TodoVO d = new TodoVO(num, when, what);
				
				// 3. 정보를 보내서 저장한다.
				try {
					dao.insert(d);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
			
			// d: 할 일 목록 지우기
			}else if(cmd.equals("d")) {
				// 1. 리스트 넘버를 받는다.
				System.out.println("Write the order: ");
				String num = sc.next();
				// 리스트 넘버를 숫자로 안 쓴 경우
				try {
					Integer.parseInt(num);
				}catch(Exception e) {
					System.out.println("Type only numbers.\n");
					continue;
				}
				
				// 2. 해당 리스트를 지운다.
				try {
					dao.delete(num);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
				
			 //r: 달성된 모든 목록을 지운다.
			}else if(cmd.equals("r")) {
				try {
					dao.delete();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
				
			// u: 정보를 업데이트한다. True False (Exception 1)??
			}else if(cmd.equals("u")) {
				System.out.println("Opt done.");
				System.out.println("Inpute the order: ");
				String num = sc.next();
			
				// 정보를 바꿈.
				try {
					dao.update(num);
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				System.out.println();
				
			// s: 정보를 불러낸다.	(Exception 완료)
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
				
			// a: DB에 있는 모든 정보를 불러낸다. (Exception 완료)
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
			
			// f: 선택한 완료유무에 대한 모든 목록을 보여준다.
			}else if(cmd.equals("f")) {
				System.out.println("Done or Ongoing lists(true/false): ");
				String check = sc.next();
				
				// input이 true or false가 아닌 경우
				if(!(check.equals("true")) && !(check.equals("false"))) {
					System.out.println("Type only 'true' or 'false'.\n");
					continue;
				}
				
				boolean done = Boolean.parseBoolean(check);
				
				ArrayList<TodoVO> a = new ArrayList<TodoVO>();
				// 정보를 보냄.
				try {
					a = search.search(done);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				// 정보의 리스트를 보여준다.
				for (TodoVO o : a) {
					System.out.println(o);
				}
				System.out.println();
				
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
