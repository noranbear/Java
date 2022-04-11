package ch04;
/**
 * for loop & while loop
 * @author Sohee Kim
 * @date 2022-04-11
 */
public class P119 {

	public static void main(String[] args) {
		
		System.out.println("Start....");
		
		// 1부터 10까지 반복하여
		for (int i = 1; i <= 10; i++) {
			System.out.println("For ...." + i);
		}
		
		System.out.println("End....");
		
		int s = 1;	// 시작점
		while(s <= 10) {
			System.out.println("while ...." + s);		// 동작한 다음에 증가가 일어나야 한다.
			s++;	// 증가
		}	// end while
	}

}
