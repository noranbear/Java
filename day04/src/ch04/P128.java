package ch04;

import java.util.Random;
import java.util.Scanner;

/**
 * 메뉴 안에 심화메뉴 구현 연습
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
				// 1. 두 개의 숫자를 입력 받는다. (조건: 두 수는 숫자이어야 하며 1 ~ 99까지의 숫자이어야 한다. 첫 번째 숫자는 두번째 숫자보다 작아야 한다)
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
					continue;				// continue statement breaks one iteration (in the loop) -> if절에 영향x
				}
				if((num1 < 1 || num1 > 99)||(num2 < 1 || num2 > 99)){
					System.out.println("You put the input in a wrong range.\n");
					continue;
				}
				if(num1 > num2){
					System.out.println("The second input should be bigger than the first.\n");
					continue;
				}
				
				// 2. 첫 번째 숫자부터 두 번째 숫자까지의 합과 평균을 구하시오.
				double sum = 0.0;
				int count = 0;
				for(int i= num1; i <= num2; i++) {
					sum += i;
					count++;
				}
				System.out.printf("첫번째 수: %d\n두번째 수: %d\n", num1, num2);
				System.out.printf("합: %.0f\n", sum);
				System.out.printf("평균: %.1f\n\n", sum/count);
			
			// Ws02
			}else if(cmd.equals("w2")) {
				// 1. 10~99까지의 숫자를 입력 받는다. (조건: 숫자여야 하며 범위안에 숫자여야 한다)
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
				
				// 2. 2부터 입력 받은 숫자까지해서 난수를 발생시킨다.
				Random r = new Random();
				int rn = r.nextInt(num-1) + 2;
				
				// 3. 1부터 난수까지의 합과 평균을 구한다. 단, 짝수들의 값의 합과 평균만을 구한다.
				double sum = 0.0;
				int count = 0;
				for(int i = 2; i <= rn; i += 2) {
					sum += i;
					count ++;
				}
				System.out.printf("난수: %d\n", rn);
				System.out.printf("합: %.0f\n", sum);
				System.out.printf("평균: %.1f\n\n", sum/count);
				
			}else {
				System.out.println("You put the wrong input.\n");
				continue;
			}
		}
		
		sc.close();
		System.out.println("End..."); 
	}

}
