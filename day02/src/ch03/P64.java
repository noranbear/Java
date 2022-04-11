package ch03;
/**
 * 연산자
 * @author Sohee Kim
 * @date 2022-04-05
 */
public class P64 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		// 단항연산자
		System.out.println("단항연산자:");
		
		int aa = -a;
		// int bb = ++b; //21
		int bb = b++;
		System.out.println(bb); // 20
		System.out.println(b);  // 21
		System.out.println();
		
		// 시험문제에 많이 나오는 것.
		int c = 10;
		int d = 10;
		// int sum = c++ + ++d;   // 21??
		int sum = c++ + d++;   // 20
		System.out.println(sum);
		System.out.println(c);
		System.out.println(d);
		
		
		// 이항연산자
		System.out.println("\n이항연산자:");
		
		int result = 10 + 20;
		
		int result2 = a % b;
		System.out.println(result2);
		
		int data = 100;
		// data = data + 1;는 아래와 같은 말. 아래가 더 빠르다.
		data += 1;
		
		
		// 비교연산
		System.out.println("\n비교연산:");
		
		int a1 = 10;
		int a2 = 20;
		
		if(a1 <= a2) {
			System.out.println("OK");
		}else {
			System.out.println("FAIL");
		}
		
		
		// 논리연산
		System.out.println("\n논리연산:");
		
		int b1 = 10;
		int b2 = 20;
		int d1 = 10;
		int d2 = 20;
		
		// || or
		// && and, *** &일 때는 앞의 condition이 false여도 두 condition을 다 본다
		
		if((b1 < b2) || (d1 > d2)) {
			System.out.println("OK");
		}else {
			System.out.println("FAIL");
		}
		System.out.println();
		
		// 시험 문제 가능성!
		// && - &보다 퍼포먼스 측면에서 결과를 내기 좋음 (뒷 부분을 안 확인해도 false인 것을 알 때를 위해 이후에 만들어짐)
		if((b1 > b2) && (d1 < d2++)) {
			System.out.println("OK");
		}else {
			System.out.println("FAIL");
			System.out.println(d2);   // 20
		}
		
		// & - 이게 보통 다른 언어의 기본 (두개 다 봄)
		if((b1 > b2) & (d1 < d2++)) {
			System.out.println("OK");
		}else {
			System.out.println("FAIL");
			System.out.println(d2);   // 21
		}
		System.out.println();
		
		// ! not (true or false 문장에서만 성립)
		if(!(b1 > b2)) {
			System.out.println("b2 is greater than b1");
		}else {
			System.out.println("b1 is greater than b2");
		}
	
		
		// 삼항연산자
		System.out.println("\n삼항연산자");
		
		int e1 = 10;
		int e2 = 20;
		int result3 = 0;
		
		if(e1 <= e2) {
			result3 = 100;
		}else {
			result3 = 200;
		}
		System.out.println(result3);
		
		// 위에 것을 삼황연산자를 이용하여 한 줄로 줄여버림.
		int result4 = (e1 <= e2) ? 100 : 200;
		System.out.println(result4);

	}

}
