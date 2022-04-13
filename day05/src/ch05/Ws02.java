package ch05;

import java.util.Random;

/**
 * Workshop02
 * @author noranbear
 * @date 2022-04-12
 */
public class Ws02 {

	public static void main(String[] args) {
		// 1. int형 배열 사이즈 10인 배열을 만든다.
		int ar[] = new int[10];
		
		// 2. 1 ~ 99까지의 랜덤한 숫자를 배열에 넣는다.
		Random rn = new Random();
		for(int i = 0; i < ar.length; i++) {
			ar[i] = rn.nextInt(99) + 1;
			System.out.printf("%d\t", ar[i]);
		}
		System.out.println();
		
		// 3. 배열의 index의 값이 홀수인 값들만의 합과 평균을 구한다.
		double sum = 0;
		int cnt = 0;
		for(int i = 1; i < ar.length; i += 2) {
			sum += ar[i];
//			System.out.println(i);		// index값 확인용
			cnt++;
		}
		System.out.printf("합: %.0f\n평균: %.2f", sum, sum/cnt);
	}

}
