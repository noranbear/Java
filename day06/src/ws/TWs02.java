/**
 * 
 */
package ws;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 14. ���� 11:37:59
 */
public class TWs02 {

	public static void main(String[] args) {
		// 1. int �� ������ 6�� �迭�� �����.
		int ar[] = new int[6];
		Random rn = new Random();
		
		// 2. 1~9������ ������ ���� �ߺ����� �ʰ� �ִ´�.
		for (int i = 0; i < ar.length; i++) {
			ar[i] = rn.nextInt(8)+1;
			for (int j = 0; j < i; j++) {
				if(ar[i] == ar[j]) {
					i--;
				}
			}
		}
		System.out.println(Arrays.toString(ar));
		
		// 3. 1~9���� �� �߿� �迭������ ���� ���� ������ ���� ���϶�.
		int sum = 0;
		for(int i = 1; i < 10; i++) {
			sum += i;
		}
	
		for (int i = 0; i < ar.length; i++) {
			sum -= ar[i];
			// sum = sum - ar[i]
		}
		System.out.printf("\n��: %d", sum);
		
	}

}
