package ch05;

import java.util.Arrays;
import java.util.Random;
/**
 * �������� ���� array�� ������� ���� �־��� �� ���� �հ� ����� ���غ��Ҵ� 
 * @author noran
 *
 */
public class P150 {

	public static void main(String[] args) {
		int ar [] = new int[10];
		Random ran = new Random();
		
		// for���� �̿��Ͽ� 1 ~ 9���� ������ ����� �迭�� �־��
		
		for(int i = 0; i < ar.length; i++) {
			ar[i] = ran.nextInt(9) + 1;
			
			// �迭 ������ ����Ͻÿ�
//			System.out.println(ar[i]);
		}
		
		System.out.println(Arrays.toString(ar));
		
		// �̰Ϳ� ���� �հ� ����� ���ض�
		double sum = 0;
		for(int i = 0; i < ar.length; i++) {
			sum += ar[i];
	
		}
		System.out.printf("��: %d\n", sum);
		System.out.printf("���: %.2f", sum/ar.length);
		

	}

}
