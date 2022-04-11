package ch04;

import java.util.Scanner;

/**
 * Workshop01 해답
 * @author Sohee Kim
 * @date 2022-04-11
 */
public class Wss01 {

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
			
		}catch(Exception e){
			System.out.println("Please enter numbers.");
			sc.close();
			return;
		}
		if((num1 < 1 || num1 > 99) || (num2 < 1 || num2 > 99)) {
			System.out.println("Please enter the number between 1 ~ 99.");
			sc.close();
			return;
		}
		if(num1 > num2) { // 다른 메세지를 주고 싶어서 if문을 나눴다.
			System.out.println("Please enter a bigger number for the 2nd number.");
			sc.close();
			return;
		}
		
		// 2. 첫 번째 숫자부터 두 번째 숫자까지의 합과 평균을 구하시오.
		double sum = 0.0;	// 타입캐스트 하지 않아도 되게.
		for(int i = num1; i <= num2; i++) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println(sum/Math.abs(num1-num2)+1); // 평균값 구하는 다른 방법(시작점과 끝점을 알 때-효율적) + 절대값 구하는 방법.
		
		sc.close();
	}

}