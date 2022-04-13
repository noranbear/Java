package ch05;
/**
 * 
 * @author noran
 *
 */
public class P151 {

	public static void main(String[] args) {
		int ar [] = {1,2,3,4,5,6,7,8,9};
		
		// 배열에 홀수 번째 값들의 합과 평균을 구하시오.
		double sum = 0.0;
		int cnt = 0;
		for(int i = 1; i < ar.length; i += 2) { // 홀수값이 아닌 홀수 번째의 값
			sum += ar[i];
			cnt ++;
		}
		System.out.printf("홀수 번째 값들의 합: %.0f\n", sum);
		System.out.printf("평균: %.2f\n", sum/cnt);

	}

}
