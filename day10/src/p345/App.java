/**
 * 
 */
package p345;

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
		DAO dao = new OracleDAO();	// interface -> DAO class 연결/ Spring에서는 이거 없이도
									// 퍼즐처럼 뺏다꼈다
//		DAO dao = new MariadbDAO();	// Mariadb에 연동
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Input cmd(i,d,s,a,q): ");		
			String cmd = sc.next();							
			
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
			
			// d: 정보를 지운다.
			}else if(cmd.equals("d")) {
				System.out.println("Input Customer id: ");
				String id = sc.next();
				
				dao.delete(id);
			
			// s: 정보를 불러낸다.
			}else if(cmd.equals("s")) {
				System.out.println("Input Customer id: ");
				String id = sc.next();
				
				CustomerVO c = dao.select(id);
				System.out.println(c);
				
			// a: DB에 있는 모든 정보를 불러낸다.
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
