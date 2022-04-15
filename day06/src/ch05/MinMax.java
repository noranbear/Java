/**
 * 
 */
package ch05;

import java.util.Arrays;
import java.util.Random;

/**
 * �迭�� �������� �� ���� �� �ִ밪�� �ּҰ��� ���ϴ� ��������. (2��-����2)
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 14. ���� 2:08:05
 */
public class MinMax {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 1. int ������ 5 �迭�� �����.
		int ar[] = new int[5];
		Random rn = new Random();
		
		// 2. �� �迭�� �����ϰ� ���� �ִ´�. (1~9)
		for (int i = 0; i < ar.length; i++) {
			ar[i] = rn.nextInt(9)+1;
			for(int j = 0; j < i; j++) {
				if(ar[j] == ar[i]) {
					i--;
				}
			}
		}
		System.out.println(Arrays.toString(ar));
		
		// 3. �迭�� ���� �� �ִ밪�� �ּҰ��� ã�´�.
		int max = 0;
		int min = ar[0];			// ū ���� �־���� �񱳰� �Ǹ鼭 �� ���� ���� ���� �ȴ�.
		for (int i = 0; i < ar.length; i++) {
			if(ar[i] > max) {
				max = ar[i];
			}
			if(ar[i] < min) {
				min = ar[i];
			}
		}
		
		// 4. �ִ밪�� �ּҰ��� ����Ѵ�.
		System.out.printf("\n�ִ밪: %d\n�ּҰ�: %d", max, min);
	}

}

