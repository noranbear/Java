/**
 * 
 */
package bank;

import java.util.Random;
import java.util.Scanner;

/**
 * Bank Account Application
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 15. ���� 2:46:37
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
			//* ???? a�� ���� ������ ������ error
			System.out.println("Input cmd(a,c,d,w,q): ");		
			String cmd = sc.next();
			
			// �޴� ������
			if(cmd.equals("q")) {				
				System.out.println("Bye...");
				break;
			
			// ������� ����
			}else if(cmd.equals("a")) {
				System.out.println("Creat an bank account(y/n): ");
				String input = sc.next();
				
				if(input.equals("y")) {
					// 000-00-000000 ���� ��ȣ ���� ����
					//* ????????? int = string format 0001 ���� ������ ������ ��
					int accNo1 = rn.nextInt(1000);
					int accNo2 = rn.nextInt(100);
					int accNo3 = rn.nextInt(1000000);
					// ���� ��ȣ ����
					accNo = new String(accNo1 + "-" + accNo2 + "-" + accNo3);
					// ���� ����
					acc = new Account(accNo, 10000);
					System.out.println(acc + "\n");
					
				}else if(input.equals("n")) {
					System.out.println("Back to the menu.\n");
					continue;
					
				//* input�� y or n�� �ƴ� ��, ���޴��� ���ư�.	
				}else {
						System.out.println("Wrong input.\n");
						continue;
					
				}
				
			// ������� ��ȸ	
			}else if(cmd.equals("c")) {
				System.out.printf("Account No.: %s\nBalance: %.2f\n\n", acc.getAccNo(), acc.getBalance());
				
			// �Ա�	
			}else if(cmd.equals("d")) {
				System.out.print("Input the amount of deposit: ");
				double deposit = 0.0;
				
				//* ���ڸ� �Է� ����
				try {
					deposit = Double.parseDouble(sc.next());
				}catch(Exception e) {
					System.out.println("Wrong input.\n");
					continue;
				}
				acc.deposit(deposit);
				System.out.println();
			
			// ���
			}else if(cmd.equals("w")) {
				System.out.println("Input the amount of withrawal: ");
				double withdrawal = 0.0;
				
				//* ���ڸ� �Է� ����
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
