package ch04;
import java.util.Scanner;
/**
 * 연습문제: 계좌 (콘솔에서 키보드로 입력하는 형태)
 * @author noranbear
 *
 */
public class P135 {

	public static void main(String[] args) {
		
		// 고려사항: 
		// 1. 출금 금액이 계좌 금액보다 크면 안된다.
		System.out.println("Start...");
		double balance = 10000.0;	// 현재 계좌 잔액
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Input cmd(d,w,s,i,q): ");		
			String cmd = sc.next();							
			
			if(cmd.equals("q")) {				
				System.out.println("Quit");
				break;
			
			// 입금
			}else if(cmd.equals("d")) {
				System.out.println("[Deposit]");
				System.out.println("Amount: ");
				String snum = sc.next();
				
				// 수가 아닌 다른 게 들어왔을 때
				int add = 0;		// 우리가 입금할 때는 int로 넣는다.
				try {
					add = Integer.parseInt(snum);
				}catch(Exception e) {
					System.out.println("Please input the right amount.\n");
					continue;
				}
				
				// 음수가 들어왔을 때
				if(add < 0) {
					System.out.println("Cannot input a negative amount.\n");
					continue;
				}
				
				balance += add;			// double인 balance랑 더해지면서 double로 표현된다.
				System.out.printf("Current Balance: %.2f\n\n", balance);
				
			// 출금
			}else if(cmd.equals("w")) {
				System.out.println("[Withraw]");
				System.out.println("Amount: ");
				String snum = sc.next();
				System.out.println(snum);
				
				int subtract = 0;
				// 수가 아닌 다른 게 들어왔을 때
				try {
					subtract = Integer.parseInt(snum);
				}catch(Exception e) {
					System.out.println("Please input the right amount.\n");
					continue;
				}
				// 음수가 들어왔을 때
				if(subtract < 0) {
					System.out.println("Cannot input a negative amount.\n");
					continue;
				}
				
				// 고려사항 1: 출금 금액이 계좌 금액보다 크면 안된다.
				if(subtract > balance) {
					System.out.println("There's not enough balance.");
					System.out.printf("Current Balance: %.2f\n\n", balance);
					continue;
				}
				balance -= subtract;
				System.out.printf("Current Balance: %.2f\n\n", balance);
			
			// 조회
			}else if(cmd.equals("s")) {
				System.out.println("[Select Balance]");
				System.out.printf("Current Balance: %.2f\n\n", balance);
				
				// 계좌에 돈이 적을 때 경고
				if(balance < 200) {
					System.out.println("Your balance is low.\n");
				}
			}else if(cmd.equals("i")) {
				// 이자율을 입력하면 이자가 얼마인지를 출력 하시오.
				System.out.println("[Interest]");
				System.out.println("Rate: ");
				String sIntRate = sc.next();
				double interest = 0.0;
				
				double intRate = 0.0;
				try {
					intRate = Double.parseDouble(sIntRate);
				}catch(Exception e) {
					System.out.println("Please input the right amount.\n");
					continue;
				}
				
				interest = balance * (intRate / 100);
				
				System.out.printf("Interest Rate: %.2f%%\n", intRate); // '%' = %%
				System.out.printf("Current Balance: %.2f\nInterest: %.2f\n\n", balance, interest);
				
			}else {
				// q,d,w,s 외의 input이 들어왔을 때
				System.out.println("Select a menu.\n");
				continue;
			}
		}
		sc.close();
		System.out.println("End...");
	}		// 중복되는 코드를 객체 지향적으로 코딩해서 중복되지 않게 하는 방법 등. 현재는 코드량이 많다. 펼쳐져 있는 상태. (이후에 배울 것)
}
