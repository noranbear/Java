package ch04;
/**
 * break으로 loop 제어
 * @author Sohee Kim
 * @date 2022-04-11
 */
public class P130 {

	public static void main(String[] args) {
		// i = 7 일 때까지만 실행 해라. 
		for (int i = 1; i <= 10; i++) {
			System.out.println("For Loop:" + i);
			if(i == 7) {			// 반복문에 대한 제어
				break;
			}
		} // end for
		
		System.out.println("------------------");
		
		// while
		int s = 1;
		while(s <= 10) {
			System.out.println("While Loop:" + s);
			if(s == 7) {
				break;
			}
			s++;			// 제어문보다 위에 있으면 6번쨰 loop하고 s++되었을 때, 제어문에 걸려서 7번째 loop가 실행 x
		}

	}

}
