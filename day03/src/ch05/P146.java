package ch05;
/**
 * 비교문
 * @author Sohee Kim
 * @date 2022-04-06
 */
public class P146 {

	public static void main(String[] args) {
		
		// int 비교
		int a = 10;
		int b = 20;
		if(a > b) {
			System.out.println("OK");
		}else {
			System.out.println("No");
		}
		
		// String 비교
		System.out.println("\nCompare Strings: ");
		
		String s1 = "abc";
		String s2 = "abc";
		
		if(s1 == s2) {	// 주소 비교
			System.out.println("Equal Reference..");
		}
		
		if(s1.equals(s2)) {	// **값 비교
			System.out.println("Equal String..");
		}

	}

}
