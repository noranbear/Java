package ch04;
import java.util.Scanner;
/**
 * ��������: ���� (�ֿܼ��� Ű����� �Է��ϴ� ����)
 * @author noranbear
 *
 */
public class P135 {

	public static void main(String[] args) {
		
		// �������: 
		// 1. ��� �ݾ��� ���� �ݾ׺��� ũ�� �ȵȴ�.
		System.out.println("Start...");
		double balance = 10000.0;	// ���� ���� �ܾ�
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("Input cmd(d,w,s,i,q): ");		
			String cmd = sc.next();							
			
			if(cmd.equals("q")) {				
				System.out.println("Quit");
				break;
			
			// �Ա�
			}else if(cmd.equals("d")) {
				System.out.println("[Deposit]");
				System.out.println("Amount: ");
				String snum = sc.next();
				
				// ���� �ƴ� �ٸ� �� ������ ��
				int add = 0;		// �츮�� �Ա��� ���� int�� �ִ´�.
				try {
					add = Integer.parseInt(snum);
				}catch(Exception e) {
					System.out.println("Please input the right amount.\n");
					continue;
				}
				
				// ������ ������ ��
				if(add < 0) {
					System.out.println("Cannot input a negative amount.\n");
					continue;
				}
				
				balance += add;			// double�� balance�� �������鼭 double�� ǥ���ȴ�.
				System.out.printf("Current Balance: %.2f\n\n", balance);
				
			// ���
			}else if(cmd.equals("w")) {
				System.out.println("[Withraw]");
				System.out.println("Amount: ");
				String snum = sc.next();
				System.out.println(snum);
				
				int subtract = 0;
				// ���� �ƴ� �ٸ� �� ������ ��
				try {
					subtract = Integer.parseInt(snum);
				}catch(Exception e) {
					System.out.println("Please input the right amount.\n");
					continue;
				}
				// ������ ������ ��
				if(subtract < 0) {
					System.out.println("Cannot input a negative amount.\n");
					continue;
				}
				
				// ������� 1: ��� �ݾ��� ���� �ݾ׺��� ũ�� �ȵȴ�.
				if(subtract > balance) {
					System.out.println("There's not enough balance.");
					System.out.printf("Current Balance: %.2f\n\n", balance);
					continue;
				}
				balance -= subtract;
				System.out.printf("Current Balance: %.2f\n\n", balance);
			
			// ��ȸ
			}else if(cmd.equals("s")) {
				System.out.println("[Select Balance]");
				System.out.printf("Current Balance: %.2f\n\n", balance);
				
				// ���¿� ���� ���� �� ���
				if(balance < 200) {
					System.out.println("Your balance is low.\n");
				}
			}else if(cmd.equals("i")) {
				// �������� �Է��ϸ� ���ڰ� �������� ��� �Ͻÿ�.
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
				// q,d,w,s ���� input�� ������ ��
				System.out.println("Select a menu.\n");
				continue;
			}
		}
		sc.close();
		System.out.println("End...");
	}		// �ߺ��Ǵ� �ڵ带 ��ü ���������� �ڵ��ؼ� �ߺ����� �ʰ� �ϴ� ��� ��. ����� �ڵ差�� ����. ������ �ִ� ����. (���Ŀ� ��� ��)
}
