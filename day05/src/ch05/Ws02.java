package ch05;

import java.util.Random;

/**
 * Workshop02
 * @author noranbear
 * @date 2022-04-12
 */
public class Ws02 {

	public static void main(String[] args) {
		// 1. int�� �迭 ������ 10�� �迭�� �����.
		int ar[] = new int[10];
		
		// 2. 1 ~ 99������ ������ ���ڸ� �迭�� �ִ´�.
		Random rn = new Random();
		for(int i = 0; i < ar.length; i++) {
			ar[i] = rn.nextInt(99) + 1;
			System.out.printf("%d\t", ar[i]);
		}
		System.out.println();
		
		// 3. �迭�� index�� ���� Ȧ���� ���鸸�� �հ� ����� ���Ѵ�.
		double sum = 0;
		int cnt = 0;
		for(int i = 1; i < ar.length; i += 2) {
			sum += ar[i];
//			System.out.println(i);		// index�� Ȯ�ο�
			cnt++;
		}
		System.out.printf("��: %.0f\n���: %.2f", sum, sum/cnt);
	}

}
