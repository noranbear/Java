package ch05;

//import java.util.Arrays;
import java.util.Random;

/**
 * Workshop01
 * @author noranbear
 * @2022-04-12
 */
public class Ws01 {

	public static void main(String[] args) {
		// 1. double 형 배열 사이즈 5인 배열을 만들고 0.0 ~ 10.0 사이의 랜덤한 값을 넣는다.
		double ar [] = new double [5];
		Random rn = new Random();
		
		double result = 0.0;
		double random = 0.0;
		for(int i = 0; i < ar.length; i++) {
			random = rn.nextDouble();
			// random double value in range: double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();  ??????
			result = 10.0 * random;
			ar[i] = result;
			
			// 2. 값을 출력 한다.
			System.out.printf("%.2f\t",ar[i]);
		}
		System.out.println();
			
//		System.out.println(Arrays.toString(ar));

	}

}
