package ch04;

import java.util.Random;

/**
 * for loop�� ����� random���� ���� ���������� �հ� ����� ���ϴ� Ȱ�빮��.
 * @author Sohee
 * @date 2022-04-11
 */
public class P121 {

	public static void main(String[] args) {
		// Random�� ���� 2~99������ ������ �߻� ��Ų��.
		Random r = new Random();
		int ran = r.nextInt(98) + 2;
		double sum = 0;
		int count = 0;
		
		// 1���� ���������� �հ� ����� ����Ѵ�. (for)
		for(int i = 1; i <= ran; i++) {
			sum += i;
			count++;
		}
		System.out.printf("����: %d\n", ran);
		System.out.println("------------------------------");
		System.out.printf("��: %.0f\n",sum);
		System.out.printf("���: %.2f", sum/count); // double/int = double
		
		
	}

}
