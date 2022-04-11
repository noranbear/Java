package ch04;
/**
 * continue로 loop 제어
 * @author Sohee Kim
 * @date 2022-04-11
 */
public class P132 {

	public static void main(String[] args) {
		// i가 짝수일때만 출력 하시오
		for (int i = 1; i <= 10; i++) {
			if(i%2 == 1) {
				continue; // loop 안의 밑의 라인 skip
			}
			System.out.println("For Loop:" + i);
		} // end for
		
		System.out.println("------------------");
		
		// while
		int s = 1;
		while(s <= 10) {		// 이렇게만하면 s값이 안 바껴서 진행 불가.
			if (s%2 == 1) {
				s++;		// 홀수일 때 s++
				continue;
			}			
			System.out.println("While Loop:" + s);
			s++;	// 짝수일 때 s++
		}

	}

}
