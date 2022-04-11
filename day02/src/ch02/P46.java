package ch02;
/**
 * int, double type의 크기와 변환
 * @author Sohee Kim
 * @date 2022-04-05
 */
public class P46 {

	public static void main(String[] args) {
//		double d1 = 100000000000000000000000000000; // error: 실수이기 때문에 .0을 뒤에 붙여야 한다. (int 크기도 넘어가서 int가 double로
													//자동변환되는 것도 없다.
		double d1 = 100000000000000000000000000000.0;
//		float f1 = 1000000000000000000000000.0; // 이 정도의 크기는 안 들어간다.
		// 따라서 은행계좌의 크기도 double 타입으로 많이 쓰인다. (통화 등)
		// 사이트 접속량 등 (long), 게임 HP (int)...
		double d2 = 10;   // 자동 타입캐스팅. 실수보다 작은 범위의 값들을 선언해서 집어넣는 것은 자유롭게 가능하다.
		
		System.out.println("double -> integer type casting:");
		int a = (int)10.1;   // 큰 거에서 작은 거는 캐스팅을 해야 한다.
		int b = (int)1000000000000.0; // result: 잘못된 값. 잘라 없어진다.
		System.out.println(a);
		System.out.println(b);
		
//		double d3 = 10000000000; // error: int범위를 넘어가서.
		double d3 = 10000000000.0;

	}

}
