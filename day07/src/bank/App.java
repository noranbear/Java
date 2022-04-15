/**
 * 
 */
package bank;

import java.util.Random;
import java.util.Scanner;

/**
 * Bank Account Application
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 15. 오후 2:46:37
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Start...");
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();
		Account acc = null;
		String accNo = null;
		
		while(true) {		
			//* ???? a를 먼저 누르지 않으면 error
			System.out.println("Input cmd(a,c,d,w,q): ");		
			String cmd = sc.next();
			
			// 메뉴 나가기
			if(cmd.equals("q")) {				
				System.out.println("Bye...");
				break;
			
			// 은행계좌 생성
			}else if(cmd.equals("a")) {
				System.out.println("Creat an bank account(y/n): ");
				String input = sc.next();
				
				if(input.equals("y")) {
					// 000-00-000000 계좌 번호 랜덤 생성
					//* ????????? int = string format 0001 같이 나오게 만들어야 함
					int accNo1 = rn.nextInt(1000);
					int accNo2 = rn.nextInt(100);
					int accNo3 = rn.nextInt(1000000);
					// 계좌 번호 생성
					accNo = new String(accNo1 + "-" + accNo2 + "-" + accNo3);
					// 계좌 생성
					acc = new Account(accNo, 10000);
					System.out.println(acc + "\n");
					
				}else if(input.equals("n")) {
					System.out.println("Back to the menu.\n");
					continue;
					
				//* input이 y or n가 아닐 때, 본메뉴로 돌아감.	
				}else {
						System.out.println("Wrong input.\n");
						continue;
					
				}
				
			// 은행계좌 조회	
			}else if(cmd.equals("c")) {
				System.out.printf("Account No.: %s\nBalance: %.2f\n\n", acc.getAccNo(), acc.getBalance());
				
			// 입금	
			}else if(cmd.equals("d")) {
				System.out.print("Input the amount of deposit: ");
				double deposit = 0.0;
				
				//* 숫자만 입력 가능
				try {
					deposit = Double.parseDouble(sc.next());
				}catch(Exception e) {
					System.out.println("Wrong input.\n");
					continue;
				}
				acc.deposit(deposit);
				System.out.println();
			
			// 출금
			}else if(cmd.equals("w")) {
				System.out.println("Input the amount of withrawal: ");
				double withdrawal = 0.0;
				
				//* 숫자만 입력 가능
				try {
					withdrawal  = Double.parseDouble(sc.next());
				}catch(Exception e) {
					System.out.println("Wrong input.");
					continue;
				}
				acc.withdraw(withdrawal);	
				System.out.println();
				
			}
		}
		
		sc.close();
		System.out.println("See you. Have a good day.");

	}

}
