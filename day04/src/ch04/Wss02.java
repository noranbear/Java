package ch04;

import java.util.Random;
import java.util.Scanner;

/**
 * Workshop02 해답
 * @author Sohee Kim
 * @date 2022-04-11
 */
public class Wss02 {

	public static void main(String[] args) {
		// 1. 10~99까지의 숫자를 입력 받는다. (조건: 숫자여야 하며 범위안에 숫자여야 한다)
		Scanner sc = new Scanner(System.in);		// sc.close();를 바로 만들자.
		
		System.out.println("Enter a number (10~99): ");
		String snum = sc.next();
		
		int num = 0;
		try{
			num = Integer.parseInt(snum);
			
		}catch(Exception e) {
			System.out.println("Please enter a number.");
			sc.close();
			return;
		}
		if(num < 10 || num > 99 ) {
			System.out.println("Please enter a number in range 10 ~ 99.");
			sc.close();
			return;
		}
		// 2. 2부터 입력 받은 숫자까지해서 난수를 발생시킨다.
		Random ran = new Random();			// Math.random 이라는 것도 있다.
		int rn = ran.nextInt(num-1) + 2; 
		
		// 3. 1부터 난수까지의 합과 평균을 구한다. 단, 짝수들의 값의 합과 평균만을 구한다.
		double sum = 0.0;
		int count = 0;
		for(int i = 1; i <= rn; i++ ) {			//+. 만약 rn이 십만번이라면 속도 엄청 느려져서 fail -> 좀 더 효율적인 형태 
												// -> Ws02 방법(모든 홀수 짝수 돌아보고 비교할 필요 없이, 짝수만 확인=> 10만번 -> 5만번)
			if(i%2 == 0) {		// or continue
			sum += i;
			count++;
			}
		}
		System.out.printf("난수: %d\n", rn);
		System.out.printf("합: %d\n", sum);
		System.out.printf("평균: %.1f", sum/count);

		sc.close();
	}

}
