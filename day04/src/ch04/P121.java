package ch04;

import java.util.Random;

/**
 * for loop를 사용해 random으로 만든 난수까지의 합과 평균을 구하는 활용문제.
 * @author Sohee
 * @date 2022-04-11
 */
public class P121 {

	public static void main(String[] args) {
		// Random을 통해 2~99까지의 난수를 발생 시킨다.
		Random r = new Random();
		int ran = r.nextInt(98) + 2;
		double sum = 0;
		int count = 0;
		
		// 1부터 난수까지의 합과 평균을 출력한다. (for)
		for(int i = 1; i <= ran; i++) {
			sum += i;
			count++;
		}
		System.out.printf("난수: %d\n", ran);
		System.out.println("------------------------------");
		System.out.printf("합: %.0f\n",sum);
		System.out.printf("평균: %.2f", sum/count); // double/int = double
		
		
	}

}
