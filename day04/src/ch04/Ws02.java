package ch04;

import java.util.Random;
import java.util.Scanner;

/**
 * Workshop02
 * @author Sohee Kim
 * @date 2022-04-11
 */
public class Ws02 {

	public static void main(String[] args) {
		// 1. 10~99까지의 숫자를 입력 받는다. (조건: 숫자여야 하며 범위안에 숫자여야 한다)
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a number (10~99): ");
		String snum = sc.next();
		
		int num = 0;
		try{
			num = Integer.parseInt(snum);
			if(num < 10 || num > 99 ) {
				System.out.println("Please enter a number in range 10 ~ 99.");
				sc.close();
				return;
			}
		}catch(Exception e) {
			System.out.println("Please enter a number.");
			sc.close();
			return;
		}
		
		
		// 2. 2부터 입력 받은 숫자까지해서 난수를 발생시킨다.
		Random ran = new Random();
		int rn = ran.nextInt(num-1) + 2; 
		
		// 3. 1부터 난수까지의 합과 평균을 구한다. 단, 짝수들의 값의 합과 평균만을 구한다.
		int sum = 0;
		int count = 0;
		for(int i = 2; i <= rn; i+=2 ) {
			sum += i;
			count++;
		}
		System.out.printf("난수: %d\n", rn);
		System.out.printf("합: %d\n", sum);
		System.out.printf("평균: %.1f", (double)sum/count);

		sc.close();
	}

}
