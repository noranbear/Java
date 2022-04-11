package ch04;

import java.util.Scanner;

/**
 * Workship: loop�� ����Ͽ� �հ� ��հ� ���ϱ�
 * @author Sohee Kim
 * @date 2022-04-06
 */
public class P110 {

	public static void main(String[] args) {
		// 1. ���ڸ� ���� �Է� �޴´� (10~99 ������ ��)
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
		
		
		// 2. 1���� �Է� ���� ���ڱ����� �հ� ����� ���Ͻÿ�.
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
