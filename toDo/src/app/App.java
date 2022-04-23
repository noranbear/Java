
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
 * @version 3.0
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
				// ???리스트 넘버를 숫자로 안 쓴 경우 (계속 반복된다)
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
				
				// 2. 리스트 지우기
				try {
					dao.delete(num);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
				
			 //r: 달성된 모든 목록을 지우기
			}else if(cmd.equals("r")) {
				try {
					dao.delete();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				System.out.println();
				
			// u: 이룬 일을 '달성'으로 체크하기
			}else if(cmd.equals("u")) {
				// 1. 체크할 리스트 넘버를 받는다.
				System.out.println("Opt done.");
				System.out.println("Inpute the order: ");
				String num = sc.next();
				// 리스트 넘버를 숫자로 안 쓴 경우
				try {
					Integer.parseInt(num);
				}catch(Exception e) {
					System.out.println("Type only numbers.\n");
					continue;
				}
				
				// 2. '달성'으로 체크한다.
				try {
					dao.update(num);
				} catch (Exception e1) {
					System.out.println(e1.getMessage());
				}
				System.out.println();
				
			// s: 리스트 확인
			}else if(cmd.equals("s")) {
				// 1. 보여줄 리스트 넘버를 받는다.
				System.out.println("Input the order: ");
				String num = sc.next();
				// 리스트 넘버를 숫자로 안 쓴 경우
				try {
					Integer.parseInt(num);
				}catch(Exception e) {
					System.out.println("Type only numbers.\n");
					continue;
				}
				
				// 2. 해당 리스트의 정보를 가져온다.
				TodoVO o = null;
				try {
					o = dao.select(num);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				// 3. 해당 리스트를 보여준다.
				System.out.println(o);
				System.out.println();
				
			// a: DB에 있는 모든 정보를 불러낸다.
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
				// 1. 보고 싶은 리스트의 달성유무를 받는다.
				System.out.println("Done or Ongoing lists(true/false): ");
				String check = sc.next();
				
				// input이 true or false가 아닌 경우
				if(!(check.equals("true")) && !(check.equals("false"))) {
					System.out.println("Type only 'true' or 'false'.\n");
					continue;
				}
				
				boolean done = Boolean.parseBoolean(check);
				
				ArrayList<TodoVO> a = new ArrayList<TodoVO>();
				
				// 2. 해당 달성유무의 목록들을 찾는다.
				try {
					a = search.search(done);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
				// 3. 찾은 목록들을 보여준다.
				for (TodoVO o : a) {
					System.out.println(o);
				}
				System.out.println();
				
			}else {
				// 메뉴 외의 input이 들어온 경우
				System.out.println("Select a menu.\n");
				continue;
			}
		}
		sc.close();
		System.out.println("End...");

	}

}
