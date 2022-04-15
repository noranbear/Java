/**
 * 
 */
package ws;

import java.util.Random;
import java.util.Scanner;

/**
 * Number Death Game
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 14. 오후 2:38:14
 */
public class Ws01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 1. 1에서 99사이의 난수를 하나 부여한다.
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();
		int goalNum = rn.nextInt(99)+1;
		int chance = 10;
		int num = 0;
		
		while(true) {
			// 6. 10회 이상 입력하면 game over.
			if(chance == 0) {
				System.out.println("\nYou used all of the chances.");
				System.out.println("You d.i.e.d.");
				System.out.println("\tO");
				System.out.println("\to");
				System.out.println("\t.");
				System.out.println("Restart (s) or Quit (q):");
				String cmd = sc.next();
				
				//* 이겼을 시, 재시작 또는 게임종료
				if(cmd.equals("s")) {
					System.out.println("\n------------ RESTART------------\n");
					goalNum = rn.nextInt(99)+1;
					chance = 10;
					continue;
				}else if(cmd.equals("q")) {
					System.out.println("Good Bye~");
					sc.close();
					return;
				}
			}
			
			// 2. 숫자를 입력한다.
			System.out.printf("%d Guess (1~99): \n", chance);
			String snum = sc.next();
			
			//* input이 숫자가 아닐 떄
			try {
				num = Integer.parseInt(snum);
			}catch(Exception e) {
				System.out.println("You put a wrong input.\n");
				continue;
			}
			//* input이 범위를 벗어났을 때
			if(num < 1 || num > 99) {
				System.out.println("This number is out of the range.\n");
				chance--;
				continue;
			}
			
			// 3. 입력한 숫자가 해당숫자보다 작으면, down.
			if(num > goalNum) {
				System.out.println("Down\n");
				chance --;
				
			// 4. 입력한 숫자가 해당숫자보다 크면, up.
			}else if(num < goalNum) {
				System.out.println("Up\n");
				chance --;
			
			// 5. 해당숫자를 맞추면 win.
			}else if(num == goalNum) {
				System.out.printf("You got correct: %d\n", goalNum);
				System.out.println("Winner Winner Chicken Dinner!");
				System.out.println("\tO");
				System.out.println("\to");
				System.out.println("\t.");
				System.out.println("Restart (s) or Quit (q):");
				String cmd = sc.next();
				
				//* 이겼을 시, 재시작 또는 게임종료
				if(cmd.equals("s")) {
					System.out.println("\n------------ RESTART------------\n");
					goalNum = rn.nextInt(99)+1;
					chance = 10;
					continue;
				}else if(cmd.equals("q")) {
					System.out.println("Good Bye~");
					sc.close();
					return;
				}
			}
		}
	}

}
