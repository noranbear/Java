package ch04;

import java.util.Random;
import java.util.Scanner;

/**
 * �޴� �ȿ� ��ȭ�޴� ���� ����
 * @author Sohee Kim
 * @date 2022-04-11
 */
public class P128 {

	public static void main(String[] args) {
		System.out.println("Start...");
		Scanner sc = new Scanner(System.in);
		
		while(true) {		
			System.out.println("Input cmd(w1,w2,q): ");		
			String cmd = sc.next();							
			
			if(cmd.equals("q")) {				
				System.out.println("Bye...");
				break;		// Jumps out of loop
				
			// Ws01
			}else if(cmd.equals("w1")) {
				// 1. �� ���� ���ڸ� �Է� �޴´�. (����: �� ���� �����̾�� �ϸ� 1 ~ 99������ �����̾�� �Ѵ�. ù ��° ���ڴ� �ι�° ���ں��� �۾ƾ� �Ѵ�)
				System.out.println("W1 Input the 1st number(1~99): ");
				String snum1 = sc.next();
				System.out.println("Input the 2nd number(the 1st number < the 2nd number): ");
				String snum2 = sc.next();
			
				int num1 = 0;
				int num2 = 0;
				try {
					num1 = Integer.parseInt(snum1);
					num2 = Integer.parseInt(snum2);
				}catch(Exception e) {
					System.out.println("You put the wrong input.\n");
					continue;				// continue statement breaks one iteration (in the loop) -> if���� ����x
				}
				if((num1 < 1 || num1 > 99)||(num2 < 1 || num2 > 99)){
					System.out.println("You put the input in a wrong range.\n");
					continue;
				}
				if(num1 > num2){
					System.out.println("The second input should be bigger than the first.\n");
					continue;
				}
				
				// 2. ù ��° ���ں��� �� ��° ���ڱ����� �հ� ����� ���Ͻÿ�.
				double sum = 0.0;
				int count = 0;
				for(int i= num1; i <= num2; i++) {
					sum += i;
					count++;
				}
				System.out.printf("ù��° ��: %d\n�ι�° ��: %d\n", num1, num2);
				System.out.printf("��: %.0f\n", sum);
				System.out.printf("���: %.1f\n\n", sum/count);
			
			// Ws02
			}else if(cmd.equals("w2")) {
				// 1. 10~99������ ���ڸ� �Է� �޴´�. (����: ���ڿ��� �ϸ� �����ȿ� ���ڿ��� �Ѵ�)
				System.out.println("W2 Input number(10~99): ");
				String snum = sc.next();
				System.out.println(snum);
				
				int num = 0;
				try {
					num = Integer.parseInt(snum);
				}catch(Exception e) {
					System.out.println("You put the wrong input.\n");
					continue;
				}
				if(num < 10 || num > 99){
					System.out.println("You put the input in a wrong range.\n");
					continue;
				}
				
				// 2. 2���� �Է� ���� ���ڱ����ؼ� ������ �߻���Ų��.
				Random r = new Random();
				int rn = r.nextInt(num-1) + 2;
				
				// 3. 1���� ���������� �հ� ����� ���Ѵ�. ��, ¦������ ���� �հ� ��ո��� ���Ѵ�.
				double sum = 0.0;
				int count = 0;
				for(int i = 2; i <= rn; i += 2) {
					sum += i;
					count ++;
				}
				System.out.printf("����: %d\n", rn);
				System.out.printf("��: %.0f\n", sum);
				System.out.printf("���: %.1f\n\n", sum/count);
				
			}else {
				System.out.println("You put the wrong input.\n");
				continue;
			}
		}
		
		sc.close();
		System.out.println("End..."); 
	}

}
