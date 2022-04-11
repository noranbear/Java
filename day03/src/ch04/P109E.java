package ch04;

import java.util.Scanner;

/**
 * Workshop: 입력 -> 연산 -> 결과내기 (각종 변수 제한하기) - 사실 자바의 코딩 방식이 아니다;; 이건 절차형느낌... 자바가 아니여, 객체지향으로 넘어가야지 자바시작.
 * @author Sohee Kim
 * @date 2022-04-06
 */
public class P109E {

	public static void main(String[] args) {

		double num1 = 0.0;
		double num2 = 0.0;
		double result = 0.0;
		Scanner sc = new Scanner(System.in);
		
		// 1. 숫자 2개와 연산자를 입력 받는다 (3가지를 입력 받는다) (+, -, / , x)
		System.out.println("Enter the 1st number: ");
		String snum1 = sc.next();
		
		System.out.println("Enter the 2nd number: ");
		String snum2 = sc.next();
		
		System.out.println("Enter an operator (+, -, /, x): ");
		String op = sc.next();
		
		// OP 검증 - 철통보완
		if (op.length() > 1 || (!(op.equals("+")) 
							&& !(op.equals("-")) 
							&& !(op.equals("/")) 
							&& !(op.equals("x"))) ) {
			
				System.out.println("Your input for the operator is wrong. \nBye");
					sc.close();
					return;
				}
				
		System.out.printf("You entered %s, %s, and %s.\n", snum1, snum2, op);  // double로 쓸 것 없이 String으로 입력하면 유저가 입력한 대로
		   																		// 나올 것이다.
		
		// 숫자만 입력 받는다. (만약, 앞자리는 숫자고 뒷자리는 문자면?) => loop를 사용해야 할 듯.('예외사항'을 이후에 공부할 것이다)
		try {	// 문제발생
			num1 = Double.parseDouble(snum1);
			num2 = Double.parseDouble(snum2);
		}catch(Exception e) {		// 잡아서 처리.	
			System.out.println("\nWrong Input. \nPlease enter a number only. \nOk Bye...");
			sc.close();
			return;
		}
		
		// op가 두 개 이상으로 input이 돼도, 여기에서 걸러짐.
		if(op.equals("+")) {
			result = num1 + num2; 
		}else if(op.equals("-")){
			result = num1 - num2;
		}else if(op.equals("/")) {
			result = num1 / num2;
		}else if(op.equals("x")||op.equals("X")){
			result = num1 * num2;
		}else {
			System.out.println("Your input is wrong. \nBye");
			sc.close();
			return;
		}
		
		// 2. 연산된 결과를 출력 한다. 단, 소숫점 이하까지 출력 (소숫점 3자리에서 반올림)
		System.out.printf("결과값은 %.2f로 ", result);
		
//		// 3. 연산된 결과가 음수인지 양수인지 출력 한다.
//		String str = String.valueOf(result);		// double이니까 굳이 이럴 필요없이 0이랑 비교했으면 됐었네...
//		char sign = str.charAt(0);
//		if(sign == '-') {
//			System.out.printf("음수이며 ", result);
//		}else {
//			System.out.printf("양수이며 ", result);
//		}
		
		// 3번의 삼항 버전
		String str = "";
		str = (result < 0) ? "음수" : "양수";
		System.out.printf("%s이며 ", str);
		
		// 4. 연산된 결과 값이 10이상이면 큰수. 5이상이면 중간수, 5미만이면 작은수 출력
		// println 보다 String을 써봤다.
		String str2 = "";
		if(result >= 10) {
			str2 = "큰수 입니다.";
//			System.out.println("큰수 입니다.");
		}else if(result >= 5) {
			str2 = "중간수 입니다.";
//			System.out.println("중간수 입니다.");
		}else {
			str2 = "작은수 입니다.";
//			System.out.println("작은수 입니다.");
		}
		System.out.println(str2);
		
		
		sc.close();
		
//		// 실험: "11.3" 소수점도 int화 되는지 확인 -> compile error --> 당연히 안되네 ㅋㅋㅋㅋㅋ 소수점이 있는데 int하면 어떡해.. 
												// ==> double, float으로 가능
//		// 실험 2: "-11"도 int화 되는지 확인 -> 가능.
//		String num5 = "-11";
//		int a = Integer.parseInt(num5);
//		System.out.println(num5);
		
	}

}
