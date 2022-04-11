package ch04;

import java.util.Scanner;

/**
 * while loop를 사용해 Scanner로 받은 정수의 합과 평균을 구하는 활용문제.
 * @author Sohee
 * @date 2022-04-11
 */
public class P122 {

	public static void main(String[] args) {
		// 1. Scanner를 이용하여 1~99까지의 정수를 입력 받는다.
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number (1~99): ");
//		int num = s.nextInt();
		String snum = s.next();			//왜 굳이 string? -> 웹사이트에서 유저들에게 받는 정보는 보통 다 String이기 때문.
		
		// 2. 범위를 벗어나면 Bye 프로그램 종료
		int num = 0;	// 밖에다가 선언 안하면 num이 로컬로 인식되어 바깥에서 인식 불가.
		try {			// 실제 앱을 만들 때는 exception이 상당히 중요하고 많은 코딩의 양을 차지한다.
			// 수
			num = Integer.parseInt(snum);
			// 2 ~ 99
			if(num < 1 || num > 99) {				// return 두 개 중복해서 쓰는 것은 별로지만, 지금 배운 한에서는 이렇게 쓴다.
				System.out.println("Bye num ...");
				s.close();
				return;
			}
		}catch(Exception e) {
			System.out.println("Bye string");
			s.close();
			return;		// 이 function의 실행을 그만두고 여기서 끝내라는 뜻
		}
		
		// 3. 1부터 입력 받은 수까지의 합과 평균을 출력 하시오 (while)
		int i = 1;
		int sum = 0;
		while(i <= num) {
			sum += i;
			i++;
		}
		System.out.printf("난수: %d\n", num);
		System.out.printf("합: %d\n", sum);
		System.out.printf("평균: %.1f", (double)sum/(i-1));
		
		s.close(); // pipe 해제
	}

}
