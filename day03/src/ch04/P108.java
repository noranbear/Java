package ch04;

import java.util.Scanner;
//import java.lang.Math;	// for Math.pow  -- 너무 많이 써서 Default가 되어서 굳이 import를 쓰지 않아도 됨.
//import java.lang.*; // 별은 lang밑의 모든 것이라는 뜻.
/**
 * Scanner를 사용한 조건문과 실행과정
 * @author Sohee Kim
 * @date 2022-04-06
 */
public class P108 {

	public static void main(String[] args) {
//		Math.pow(0, 0);		// import 없음.
		
		System.out.println("Start ....");
		
		
		Scanner sc = new Scanner(System.in);	// import 있음.
		System.out.println("Input Number: ");
		String num = sc.next();
		int nm = Integer.parseInt(num);					// String -> int
		
		// 입력한 숫자가 0이면 프로그램 종료, 그렇지 않으면 출력
		// 1부터 10이하인 숫자가 아니면 종료
		if(!(nm >= 1 && nm <= 10)) {		// or (nm == 0 || (nm < 1 || nm > 10)
//			System.exit(0);		// 프로그램 종료
			System.out.println("Bye");
			sc.close();
			return;		// main의 끝 }으로 나간다.
		}
		
		// printf (%d, %s, %f) 정수, 문자, 실수
		System.out.printf("입력한 값은 %d이다.\n", nm);
		
		// 홀수인지 아닌지를 구하시오.
		if(nm%2 == 0) {
			System.out.printf("입력한 값 %d은/는 짝수이며 ", nm);
		}else {
			System.out.printf("입력한 값 %d은/는 홀수이며 ", nm);
		}
		
		// 대(7이상), 중(3이상), 소(3미만) 입니다.
		if(nm >= 7) {
			System.out.println("대수이다.\n");
		}else if(nm >= 3) {
			System.out.println("중수이다.\n");
		}else {
			System.out.println("소수이다.\n");
		}
		// 위의 if else statement를 삼항연산자로 변환하시오.
		String r = ""; // 초기화
		r = (nm >= 7) ? "대수" 
		  : (nm >= 3) ? "중수" 
		  : "소수";					// if문에 비해 속도가 빨라지는 것은 아님.
		System.out.println(r);		// 가독성에 도움이 될 수도 방해가 될 수도 있음.
		

		sc.close();
		System.out.println("End ....");
	}

}
