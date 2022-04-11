package ch03;
/**
 * 나누기에서 유의할 점
 * @author Sohee Kim
 * @date 2022-04-05
 */
public class P84 {
	
	public static void main(String[] args) {
		int a = 10;
		int b = 0;   // Exception: 0으로 나눌 수 없기 때문에 compile error가 뜬다. (compile error가 뜨면, 뜬 줄에서 프로그램은 멈춘다)
		int c = 3;
		int result = 0;
		double result2 = 0;
		
		// => 에러가 뜰 가능성이 있는 경우, 제어를 해줘야 한다.
		if(b != 0) {
			result = a / b;
		}
		  
		result2 = (double)a / (double)c;   // 소수점까지 얻고 싶으면 하나하나 double로 타입캐스팅을 해줘야 한다.
											// 결과는 소수점 자리가 어느정도에서 자동으로 잘라진다. -> 그러므로, 어디에서 잘라질지 정해야 한다.
											// a나 c 둘 중의 하나만 double로 타입캐스팅되어도 결과는 소수점까지 똑같다.
		System.out.println(result);
		System.out.println(result2);
	}
}
