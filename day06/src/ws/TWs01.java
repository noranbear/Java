/**
 * 
 */
package ws;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 14. ���� 12:36:13
 */
public class TWs01 {

	public static void main(String[] args) {
		// 1. int ������ 5 �迭�� �����.
		int ar[] = new int[5];
		Random rn = new Random();
		
		// 2. �� �迭�� �����ϰ� ���� �ִ´�. (0 ~ 100)
		for (int i = 0; i < ar.length; i++) {
			ar[i] = rn.nextInt(101);
		}

		// 3. �迭�� ���� �� �ִ밪�� ã�´�.
		int max = 0;
		for (int i = 0; i < ar.length; i++) {
			if(ar[i] > max) {
				max = ar[i];
			}
		}

		// 4. �ִ밪�� ����Ѵ�.
		System.out.println(Arrays.toString(ar));
		System.out.printf("\n�ִ밪: %d",max);
	}

}
