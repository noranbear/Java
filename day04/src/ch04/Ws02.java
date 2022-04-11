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
		// 1. 10~99������ ���ڸ� �Է� �޴´�. (����: ���ڿ��� �ϸ� �����ȿ� ���ڿ��� �Ѵ�)
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
		
		
		// 2. 2���� �Է� ���� ���ڱ����ؼ� ������ �߻���Ų��.
		Random ran = new Random();
		int rn = ran.nextInt(num-1) + 2; 
		
		// 3. 1���� ���������� �հ� ����� ���Ѵ�. ��, ¦������ ���� �հ� ��ո��� ���Ѵ�.
		int sum = 0;
		int count = 0;
		for(int i = 2; i <= rn; i+=2 ) {
			sum += i;
			count++;
		}
		System.out.printf("����: %d\n", rn);
		System.out.printf("��: %d\n", sum);
		System.out.printf("���: %.1f", (double)sum/count);

		sc.close();
	}

}
