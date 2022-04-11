package ch04;

import java.util.Scanner;

/**
 * while이라는 반복문을 이용하여 우리가 만들 앱을 조금이라도 구현해보았다.
 * @author Sohee Kim
 * @date 2022-04-11
 */
public class P127 {

	public static void main(String[] args) {
		System.out.println("Start...");
		Scanner sc = new Scanner(System.in);
		
		while(true) {		// ture -> while 계속 실행. => 무한루프 -> 메모장을 켰을 때 시스템이 살아있다. 그 상태.
			System.out.println("Input cmd(w1,w2,q)...");		// 옛날 은행에서는 실제로 이렇게 이체했다.
			String cmd = sc.next();							// -> 은행원에게 종이를 써갖다주면 은행원이 이런 코드를 써서 업무봄.
			
			if(cmd.equals("q")) {				// 옛날 그 선택지 게임 // exit을 맨 앞 case로 쓰면 exit하기 위해 다 돌면서 찾아갈 필요 x
				System.out.println("Bye...");
				break;
			}else if(cmd.equals("w1")) {
				System.out.println("W1 Input number..");
				String snum = sc.next();
				System.out.println(snum);
			}else if(cmd.equals("w2")) {
				System.out.println("W2 Input number..");
				String snum = sc.next();
				System.out.println(snum);
			}
		}
		
		sc.close();
		System.out.println("End..."); // error(Unreachable code): 무한루프 밑에 갈 일이 없으니 에러. 
									  // --> 루프를 나갈 수 있는 조건이 생기면 에러가 없어짐.

	}

}
