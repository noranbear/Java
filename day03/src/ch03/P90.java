package ch03;
/**
 * Java가 파일을 실행하는 원리. (노트 참고)
 * @author Sohee Kim
 * @date 2022-04-06
 */
public class P90 {

	public static void main(String[] args) {
		// Primitive Type
		int a = 10;
		int b = 20;
		int c = a + b;
		
		// Reference Type
		String s = "ABC";   // 알파벳 각각의 유니코드 값이 있다.
		
		System.out.println(c);
		System.out.println(s);
		
		// 컴파일할 떄, 이 코드가 실행되는 것이 아니라 이 코드가 컴파일된 클래스 파일, 즉 바이트 코드가 실행되는 것이다.
		// 어떻게 돌아가는 걸까? 우리는 그냥 초록색 run 버튼을 누르는 것 뿐인데. --> 노트 참고.

	}

}
