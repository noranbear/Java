package ch05;
/**
 * String 타입과 실행원리 (노트 참고)
 * @author Sohee Kim
 * @date 2022-04-06
 */
public class P145 {

	public static void main(String[] args) {
		String s1 = "ABC";
		String s2 = "ABC";
		String s3 = s2.toLowerCase();   // 소문자화   // .의 뜻: s2의 주소값을 변경해라. String은 한 번 메모리에 들어가면 바꿀 수 없음.
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		char c = s3.charAt(0);		// 해당 index에 있는 character를 대입한다.
		System.out.println(c);
		

	}

}
