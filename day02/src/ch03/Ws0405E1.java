package ch03;
/**
 * Extra possible ways of Workshop2 using Math class (포맷문제 발생->해결)
 * @author Sohee Kim
 * @date 2022-04-05
 *
 */
public class Ws0405E1 {

	public static void main(String[] args) {
		
		// 가로가 5 세로가 7인 직간삼각형의 빗변 길이를 구하시오. 답: 8.60233~
		double w = 5;	// width
		double h = 7;	// height
		
		// * !!! Result의 문제: 마지막 소수점 자리가 0일때 2개만 남기면 8.6으로 0이 보이지 않게 된다.
		System.out.println(Math.round(Math.hypot(w, h)*100)/100.0);
		// 해결
		System.out.format("%.2f%n", (Math.round(Math.hypot(w, h)*100))/100.0);
		System.out.format("%.2f", Math.hypot(w, h));

	}

}
