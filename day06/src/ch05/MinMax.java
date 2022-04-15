/**
 * 
 */
package ch05;

import java.util.Arrays;
import java.util.Random;

/**
 * 배열에 램덤으로 들어간 수들 중 최대값과 최소갑을 구하는 연습문제. (2조-문제2)
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 14. 오후 2:08:05
 */
public class MinMax {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 1. int 사이즈 5 배열을 만든다.
		int ar[] = new int[5];
		Random rn = new Random();
		
		// 2. 그 배열에 램덤하게 값을 넣는다. (1~9)
		for (int i = 0; i < ar.length; i++) {
			ar[i] = rn.nextInt(9)+1;
			for(int j = 0; j < i; j++) {
				if(ar[j] == ar[i]) {
					i--;
				}
			}
		}
		System.out.println(Arrays.toString(ar));
		
		// 3. 배열의 값들 중 최대값과 최소값을 찾는다.
		int max = 0;
		int min = ar[0];			// 큰 값을 넣어야지 비교과 되면서 더 작은 수가 들어가게 된다.
		for (int i = 0; i < ar.length; i++) {
			if(ar[i] > max) {
				max = ar[i];
			}
			if(ar[i] < min) {
				min = ar[i];
			}
		}
		
		// 4. 최대값과 최소값을 출력한다.
		System.out.printf("\n최대값: %d\n최소값: %d", max, min);
	}

}

