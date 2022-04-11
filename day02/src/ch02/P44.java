package ch02;
/**
 * byte, int, long type 변환과 크기
 * @author Sohee Kim
 * @date 2022-04-05
 */
public class P44 {
	
	public static void main(String[] args) {
		
		// int형에는 10진수, 8진수, 16진수가 들어갈 수 있다.
		int v1 = 10;   // 10진수
		int v2 = 012;   // 8진수 - 10진수와 차이를 만들기 위해 0을 앞에 붙이는 듯.
		int v3 = 0xA;   // 16진수
		int v4 = 0x000A;   // 16진수
		
		System.out.println("int형에 들어가는 진수들:");
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
		
		
		System.out.println("\n[byte와 +]");
		System.out.println("결과값이 byte 크기보다 작을 경우:");
		byte b1 = 10;
		byte b2 = 10;
		// Tip. '=' sign이 붙으면 무조건 오른쪽부터 읽힌다.
//		byte b3 = b1 + b2; // error: 정수의 '+' 연산(16개의 공간)이 일어나면서 결과값이 int type이 된다. 그래서 byte(8bit)에 들어가지 못 한다.
		byte b3 = (byte)(b1 + b2); // 해결법: byte로 잘라내어 버린다. -> 맨 오른쪽 마지막 8bit가 남으므로 10은 괜찮다. 
		System.out.println(b3);
		// **This looks work, but it just shows the result, not they actually add the values. So, 사칙연산이 아니므로 가능.
		System.out.println(b1 + b2);
		
		
		System.out.println("\n결과값이 byte 크기보다 클 경우:");
		byte b4 = 100;
		byte b5 = 100;
		byte b6 = (byte)(b4 + b5); // result: 이상한 값 -> 앞에 있는 값을 강제로 잘라버리기 때문에.
									// 값-> 200 or 011001000 (1byte 넘어감). -> 잘라낼 때, 11001000 (2's complement 십진법 변환값은 -56).
		System.out.println(b6);
		
		
		System.out.println("\n결과값이 int 크기보다 클 경우:");
		int vi1 = 1500000000;
		int vi2 = 1500000000;
//		int result = vi1 + vi2; // result: 이상한 값 -> 30억이 int(8byte) 안에 넣을 수 없는데 int가 기본type이어서 에러없이 값을 강제로 잘라버린다.
//		long result = (long)(vi1 + vi2); // 안된다.
		long result = (long)vi1 + (long)vi2; // 가능
		System.out.println(String.format("%,d", result)); ?? 0네 개를 원해. 은행이 떼가는 그것?
		
		// 은행계좌 만들 때, int는 21억정도 밖에 못 넣기 때문에 너무 작다. long을 쓸 수도 있지만, 정수타입인 long은 소수점 이하를 표현할 수 없다.
		// 그래서 실수형을 사용한다.
		
		long vi3 = 15000000000L; // int가 기본타입이기 때문에 21억을 넘어가는 수를 쓸 수 없다. long을 쓸 경우, 뒤에 L을 붙여주면 이 부분이 해결된다.
		long vi4 = 15000000000L;
		long result2 = vi3 + vi4;
		
		System.out.println(result2);
	}

}
