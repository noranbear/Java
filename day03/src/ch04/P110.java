package ch04;

import java.util.Scanner;

/**
 * Workship: loop를 사용하여 합과 평균값 구하기
 * @author Sohee Kim
 * @date 2022-04-06
 */
public class P110 {

	public static void main(String[] args) {
		// 1. 두자리 수를 입력 받는다 (10~99 사이의 값)
		int num = 0;
		int sum = 0;
		int count = 0;
		double ave = 0.0;
		Scanner sc = new Scanner(System.in);
		
		do {
			System.out.println("Enter a number: ");
			num = sc.nextInt();
			
			if(num < 10 || num > 99) {
				System.out.println("Please enter a number (10~99)");
			}
		}while(num < 10 || num > 99);
		
		
		// 2. 1부터 입력 받은 숫자까지의 합과 평균을 구하시오.
		for(int i = 1; i <= num; i++) {
			sum += i;
			count ++;
		}
		
		ave = sum /(double)count;
		
		System.out.printf("The sum is %d\n", sum);
		System.out.printf("The average is %.2f", ave);
		
		sc.close();
	}

}
