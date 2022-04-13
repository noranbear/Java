package ch05;
/**
 * 메모리
 * @author noran
 *
 */
public class P138 {

	public static void main(String[] args) {
		int a = 10;
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		System.out.printf("%d %s", a, s1);
		String s5 = null;		// Reference type의 초기값
		String s6 = "";			// String type은 이렇게 초기화 해도 된다. (공백)
		
		System.out.println(s5);
		
		char c = s1.charAt(1);
		System.out.println(c);
		
		int len = s2.length();
		System.out.println(len);
		
		String ns = s3.toUpperCase();
		System.out.println(ns);
		s1.toUpperCase();
		System.out.println(s1); // s1값이 uppercase로 안 바뀐다. => 한 번 만들어진 String 개체는 바꿀 수 없다. ABC로 하나가 새로 만들어진다
		
//		System.out.println(s5.length());	// nullpointerException ---> null = 아무런 주소가 들어가있지 않은 String.
		System.out.println(s6); // 아무것도 안 보임 - 공백이어서
		
		
		
		

	}

}
