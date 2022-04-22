/**
 * 
 */
package p345;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * DAO �������̽��� �°� ����� app.
 * OracleDAO�� MariadbDAO ������ ġȯ�� �����Ӵ�.
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. ���� 11:22:14
 */
public class App {

	public static void main(String[] args) {
		System.out.println("Start...");
		DAO dao = new OracleDAO();	// interface�� DAO class ����
//		DAO dao = new MariadbDAO();	// interface�� Mariadb ����
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Input cmd(i,d,s,a,q): ");		
			String cmd = sc.next();							
			
			if(cmd.equals("q")) {				
				System.out.println("Quit");
				break;
			
			// i: ������ �־ ������.
			}else if(cmd.equals("i")) {
				System.out.println("Input Customer info.");
				
				System.out.println("Input Customer id: ");
				String id = sc.next();
				System.out.println("Input Customer password: ");
				String pwd = sc.next();
				System.out.println("Input Customer name: ");
				String name = sc.next();
				
				// ������ ����.
				CustomerVO c = new CustomerVO(id, pwd, name);
				// ������ ����.
				dao.insert(c);
			
			// d: ������ �����.
			}else if(cmd.equals("d")) {
				System.out.println("Input Customer id: ");
				String id = sc.next();
				
				dao.delete(id);
			
			// s: ������ �ҷ�����.
			}else if(cmd.equals("s")) {
				System.out.println("Input Customer id: ");
				String id = sc.next();
				
				CustomerVO c = dao.select(id);
				System.out.println(c);
				
			// a: DB�� �ִ� ��� ������ �ҷ�����.
			}else if(cmd.equals("a")) {
				ArrayList<CustomerVO> a = dao.select();
				
				for (CustomerVO c : a) {
					System.out.println(c);
				}
				
			}else {
				// i, d, s, q ���� input�� ������ ��
				System.out.println("Select a menu.\n");
				continue;
			}
		}
		sc.close();
		System.out.println("End...");

	}

}
