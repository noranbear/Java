package ch04;

import java.util.Random;	// java.lang 패키지 외의 것은 import해야 한다
/**
 * switch 02 wiht random number
 * @author Sohee Kim
 * @date 2022-04-11
 */
public class P118 {

	public static void main(String[] args) {
		Random r = new Random();	// Random
//		int n = r.nextInt(3);		// 0~2
		int n = r.nextInt(3) + 1;	// 1~3
		System.out.println(n);
		
		// Switch문을 써야하는 때 (authentication 할 때 switch문이 유용하다.)
		switch (n) {
		case 1:			// 1등
			System.out.println("냉장고");
			break;						// break가 없으면 밑의 case도 다 찍힌다.
		case 2:			// 2등
			System.out.println("세탁기");
			break;
		case 3:			// 3등
			System.out.println("핸드폰");
			break;

		default:
			break;
		}
	}

}
