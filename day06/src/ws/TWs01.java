/**
 * 
 */
package ws;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 14. 오후 12:36:13
 */
public class TWs01 {

	public static void main(String[] args) {
		// 1. int 사이즈 5 배열을 만든다.
		int ar[] = new int[5];
		Random rn = new Random();
		
		// 2. 그 배열에 램덤하게 값을 넣는다. (0 ~ 100)
		for (int i = 0; i < ar.length; i++) {
			ar[i] = rn.nextInt(101);
		}

		// 3. 배열의 값들 중 최대값을 찾는다.
		int max = 0;
		for (int i = 0; i < ar.length; i++) {
			if(ar[i] > max) {
				max = ar[i];
			}
		}

		// 4. 최대값을 출력한다.
		System.out.println(Arrays.toString(ar));
		System.out.printf("\n최대값: %d",max);
	}

}
