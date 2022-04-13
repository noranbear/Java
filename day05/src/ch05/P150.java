package ch05;

import java.util.Arrays;
import java.util.Random;
/**
 * 램덤으로 값을 array에 집어넣을 수도 있었고 그 값의 합과 평균을 구해보았다 
 * @author noran
 *
 */
public class P150 {

	public static void main(String[] args) {
		int ar [] = new int[10];
		Random ran = new Random();
		
		// for문을 이용하여 1 ~ 9까지 난수를 만들어 배열에 넣어라
		
		for(int i = 0; i < ar.length; i++) {
			ar[i] = ran.nextInt(9) + 1;
			
			// 배열 내용을 출력하시오
//			System.out.println(ar[i]);
		}
		
		System.out.println(Arrays.toString(ar));
		
		// 이것에 대한 합과 평균을 구해라
		double sum = 0;
		for(int i = 0; i < ar.length; i++) {
			sum += ar[i];
	
		}
		System.out.printf("합: %d\n", sum);
		System.out.printf("평균: %.2f", sum/ar.length);
		

	}

}
