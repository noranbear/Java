package ch02;
/**
 * byte와 int, float과 double, int와 double 사이의 변수 선언과 사칙연산
 * @author Sohee Kim
 * @date 2022-04-05
 */
public class P60 {

	public static void main(String[] args) {
		byte b1 = 10; 
		byte b2 = 100;
//		float f1 = 2.5; // double이 기본이어서 double 값이된다. long처럼 옆에 float의 F를 붙여줘야 한다.
		float f1 = 2.5F;
		double d2 = 2.5;
		
		System.out.println("byte - int:");
//		byte bb = b1 + b1;   //int화
//		byte bb = (byte)b1 + (byte)b1; // 안되네?? -> *byte인 상태에서 사칙연산을 하면 int화해서 byte타입에 못 대입 한다니까~
		byte bb = (byte)(b1 + b1);  // 가능해 보이지만, 이 논리에 다른 값을 넣었을 때, 안 맞는 경우가 존재.
		byte bb2 = (byte)(b2 + b2); //잘못된 값
		int result = b1 + b1;   // 가능
		
		System.out.println(bb); // 잘 되네?
		System.out.println(bb2); // 안되는 거였네.
		System.out.println(result);
		
		
		System.out.println("\nfloat - double:");
		float ff = 5 + f1;
//		float ff2 = 5000000000000000000000000 +f1;   // error. 뒤에 f안 붙여서
		double dd = 5 + d2;
		double dd2 = 500000000000000000000000000.0 +d2;        // 작은 수인데 소수점이 있으면 double일 거라 생각해서 float타입일 때, 에러.
																// 큰 수이면 double일 거라 생각해서(소수점 유무 상관x) float타입일 때, 에러.
		System.out.println(ff);
		System.out.println(dd);
		
		
		System.out.println("\nint + double:");
		//int result2 = 100 + d2; // error: 사칙연산에서 실수와 정수가 만나면 실수 따라감.
		int result2 = 100 + (int)d2;   // 이럴 경우 소수점 이하의 수는 없어지고, d2가 int 타입의 범위를 넘어가는 값이면 안된다.
		System.out.println(result2);

	}

}
