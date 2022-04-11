package ch02;
/**
 * int를 double로 나누었을 때 왜 infinity가 나오는 지.
 * @author Sohee Kim
 * @date 2022-04-06
 */
public class P47 {

	public static void main(String[] args) {
		int a = 10;
		double b = 0.0;
		
		double result = a / b;
		System.out.println(result);
		
		System.out.printf("진짜 double 값: %f\n", b);  // printf -> b라는 결과값을 예쁘게 꾸밀거다. %f = 실수를 찍어라.
		System.out.printf("진짜 double 값: %10.2f\n", b);   // 전체 자릿수는 10자리, 소수점 이하 2자리만 잡아라
		System.out.printf("진짜 double 값: %1.50f\n", b);
		
		// 실제로 b의 값은 0.00000000~ (무한소수), 어떤 값을 무한소수로 나눌 수 없어서 나눈 값을 infinity라고 자바에서 정의했다.

		// format
		double b2 = 14.23543;
		System.out.printf("%n결과는: %5.2f", b2);   // 자동 반올림	- 콘솔에 출력 (현재 화면이 없으므로)
	}

}
