package ch03;
/**
 * Workshop2 using Math class (포맷문제 발생->해결)
 * @author Sohee Kim
 * @date 2022-04-05
 */
public class Ws0405 {

	public static void main(String[] args) {
		
		// 가로가 5 세로가 7인 직간삼각형의 빗변 길이를 구하시오. (소수점 세자리에서 반올림하시오.) 답: 8.60
		double a = 5;	// width
		double b = 7;	// height
		double c = 0;	// hypotenuse
		
		a = Math.pow(a, 2);   // power
		b = Math.pow(b, 2);
		
		c = Math.sqrt(a + b);   // square root
		
		System.out.println(c);	// Java에서 임의로 적정 소수점 내에서 반올림.
		System.out.println(Math.round(c)); // returns the closest long.
		
		// * !!! Result의 문제: 마지막 소수점 자리가 0일때 2개만 남기면 8.6으로 0이 보이지 않게 된다.
		System.out.println(Math.round(c*100)/100.0);   // round  // 뒤에만 소수점 붙이는 이유: int화를 피하기 위해.
		
//		System.out.printf("%.2f", Math.round(c)); // compile error- Math.round때문에 c가 long이 되어서 decimal number를 위한
													// format을 할 수 없다.
		// 해결법
		System.out.printf("%.2f", c);
		
	}

}
