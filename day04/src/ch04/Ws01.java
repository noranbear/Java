package ch04;

import java.util.Scanner;

/**
 * Workshop01
 * @author Sohee Kim
 * @date 2022-04-11
 */
public class Ws01 {

	public static void main(String[] args) {
		// 1. 두 개의 숫자를 입력 받는다. (조건: 두 수는 숫자이어야 하며 1 ~ 99까지의 숫자이어야 한다. 첫 번째 숫자는 두번째 숫자보다 작아야 한다)
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a number (1~99):");
		String snum1 = sc.next();
		System.out.println("Enter a number bigger than the previous number:");
		String snum2 = sc.next();
		
		int num1 = 0;
		int num2 = 0;
		try {
			num1 = Integer.parseInt(snum1);
			num2 = Integer.parseInt(snum2);
			if((num1 < 1 || num1 > 99) || (num2 < 1 || num2 > 99)) {
				System.out.println("Please enter the number between 1 ~ 99.");
				sc.close();
				return;			// finish a function
			}
			if(num1 > num2) {
				System.out.println("Please enter a bigger number for the 2nd number.");
				sc.close();
				return;
			}
		}catch(Exception e){
			System.out.println("Please enter numbers.");
			sc.close();
			return;
		}
		
		// 2. 첫 번째 숫자부터 두 번째 숫자까지의 합과 평균을 구하시오.
		int sum = 0;
		int count = 0;
		for(int i = num1; i <= num2; i++) {
			sum += i;
			count++;
		}
		System.out.printf("합: %d\n", sum);
		System.out.printf("평균: %.1f", (double)sum/count);
		
		sc.close();
	}

}
