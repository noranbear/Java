package ch04;

import java.util.Scanner;

/**
 * 
 * @author Sohee Kim
 * @date 2022-04-06
 */
public class P109 {
	// 큰 범위의 IF를 먼저 넣고 그 뒤 걸러진 애들을 작은 IF로 걸러내는 게 쉽다.
	public static void main(String[] args) {
		System.out.println("Start");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input the 1st number:");
		String n1 = sc.next();
		
		System.out.println("Input the 2nd number:");
		String n2 = sc.next();
		
		
		// 입력 받은 숫자가 한자리 수가 아니면 종료
		if(n1.length() != 1 || n2.length() != 1) {
			System.out.println("\nBye");
			sc.close();
			return;
		}
		
		// 숫자만 입력 받는다. (한 자릿수일 때) -> ASCII 사용
		
		// "1" -> '1'
		char c1 = n1.charAt(0);
		char c2 = n2.charAt(0);
//		System.out.println((int)c);		// ASCII 코드를 보여준다.
		if(!(c1 >= '1' && c1 <= '9') || !(c2 >= '1' && c2 <= '9')) {	// char은 ASCII에 의해 - 정수여서 비교 가능
																		// ||도 &&처럼 처음만 봄, 그래서 겹치는 더 넓은 범위의 컨디션을
																		// 앞에다 넣어도 괜찮다.
			System.out.println("\nBye");
			sc.close();
			return;
		}
		
//		System.out.println(n1.length());	// String의 크기를 알 수 있다. 숫자라면 자릿수.
		System.out.printf("%s , %s 입니다.\n", n1, n2);
		
		
		sc.close();
		System.out.println("\nEnd");
		
	}

}
