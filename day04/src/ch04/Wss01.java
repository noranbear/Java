package ch04;

import java.util.Scanner;

/**
 * Workshop01 �ش�
 * @author Sohee Kim
 * @date 2022-04-11
 */
public class Wss01 {

	public static void main(String[] args) {
		// 1. �� ���� ���ڸ� �Է� �޴´�. (����: �� ���� �����̾�� �ϸ� 1 ~ 99������ �����̾�� �Ѵ�. ù ��° ���ڴ� �ι�° ���ں��� �۾ƾ� �Ѵ�)
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
		if(num1 > num2) { // �ٸ� �޼����� �ְ� �; if���� ������.
			System.out.println("Please enter a bigger number for the 2nd number.");
			sc.close();
			return;
		}
		
		// 2. ù ��° ���ں��� �� ��° ���ڱ����� �հ� ����� ���Ͻÿ�.
		double sum = 0.0;	// Ÿ��ĳ��Ʈ ���� �ʾƵ� �ǰ�.
		for(int i = num1; i <= num2; i++) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println(sum/Math.abs(num1-num2)+1); // ��հ� ���ϴ� �ٸ� ���(�������� ������ �� ��-ȿ����) + ���밪 ���ϴ� ���.
		
		sc.close();
	}

}