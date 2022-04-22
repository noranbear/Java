/**
 * 
 */
package p344;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 유저에게 정보를 받아서 CustomerVO에 담은 다음, OracleDAO에 보낸다.
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. 오전 11:22:14
 */
public class App {

	public static void main(String[] args) {
		System.out.println("Start...");
		
		// OracleDAO 객체를 만든다.
		// *App과 OracleDAO를 이어주는 부분
		OracleDAO dao = new OracleDAO();	
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			// 메뉴
			System.out.println("Input cmd(i,d,s,a,q): ");		
			String cmd = sc.next();							
			
			// q: 메뉴에서 나간다.
			if(cmd.equals("q")) {				
				System.out.println("Quit");
				break;
			
			// i: 정보를 넣어서 보낸다.
			}else if(cmd.equals("i")) {
				System.out.println("Input Customer info.");
				
				System.out.println("Input Customer id: ");
				String id = sc.next();
				System.out.println("Input Customer password: ");
				String pwd = sc.next();
				System.out.println("Input Customer name: ");
				String name = sc.next();
				
				// 정보를 담음.
				CustomerVO c = new CustomerVO(id, pwd, name);
				// 정보를 보냄.
				dao.insert(c);
			
			// d: 정보를 지운다. (지웠다고 얘기해준다)
			}else if(cmd.equals("d")) {
				System.out.println("Input Customer id: ");
				String id = sc.next();
				
				dao.delete(id);
			
			// s: 정보를 불러낸다. (가상의 정보를 보내준다)
			}else if(cmd.equals("s")) {
				System.out.println("Input Customer id: ");
				String id = sc.next();
				
				CustomerVO c = dao.select(id);
				System.out.println(c);
				
			// a: DB에 있는 모든 정보를 불러낸다. (모든 가상의 정보를 보내준다)
			}else if(cmd.equals("a")) {
				ArrayList<CustomerVO> a = dao.select();
				
				for (CustomerVO c : a) {
					System.out.println(c);
				}
				
			}else {
				// i, d, s, q 외의 input이 들어왔을 때
				System.out.println("Select a menu.\n");
				continue;
			}
		}
		sc.close();
		System.out.println("End...");

	}

}
