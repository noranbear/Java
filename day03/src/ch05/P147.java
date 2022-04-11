package ch05;
/**
 * String 선언방법에 따른 파일 실행 과정의 차이점 (노트 참고)
 * @author Sohee Kim
 * @date 2022-04-06
 */
public class P147 {

	public static void main(String[] args) {
		String s1 = "ABC";
		String s2 = new String("ABC");	// 이렇게 String을 만들 수도 있다.
		String s3 = "ABC";
		String s4 = new String("ABC");
		
		if(s1 == s2) {	// 주소 비교 --> 다르므로 같지 않다.
			System.out.println("Equal Reference..");
		}
		
		if(s1.equals(s2)) {	// **값 비교 --> 값이 같으므로 다른 ABC를 가리키고 있다고 해서 
			System.out.println("Equal String..");
		}


	}

}
