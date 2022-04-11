package ch04;
/**
 * switch문
 * @author Sohee Kim
 * @2022-04-11
 */
public class P117 {

	public static void main(String[] args) {
		String a = "10";	// Switch로 비교: String, 정수 등의 타입은 가능, 실수 타입 불가능.
		switch (a) {   // 조건은 들어가지 않는다.
		case "10": 
			System.out.println("큰수");
			break;	// switch를 끝낸다.
		case "5":
			System.out.println("중간수");
			break;
		case "1":
			System.out.println("작은수");
			break;
		default:
			System.out.println("입력오류");
			break;
		}	// end switch
		System.out.println("End....");

	}

}
