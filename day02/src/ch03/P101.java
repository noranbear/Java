package ch03;
/**
 * if-statement와 삼항 연산자를 이용하여 if-statement를 구현하는 방법.
 * @author Sohee Kim
 * @date 2022-04-05
 */
public class P101 {

	public static void main(String[] args) {
		int sum = 86;
		char result = 0; // local variable은 초기화를 시켜서 사용해라, char도 정수형이기 때문에 0으로 초기화가능.
		
		// 90 이상이면 'A'
		// 80 이상이면 'B'
		// 80 미만이면 'D'
//		if(sum >= 90) {
//			result = 'A';
//		}else if(sum >= 80) {
//			result = 'B';
//		}else {
//			result = 'D';
//		}
		
		// 삼항 연산자로 위의 statement를 구현하시오.
		result = (sum >= 90) ? 'A': (sum >= 80) ? 'B': 'D';
		System.out.println(result);
		
		
	}

}
