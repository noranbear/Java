/**
 * 
 */
package lotto;

import java.util.Random;
import java.util.Scanner;

/**
 * Lotto Game in OOP
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 15. 오후 5:08:56
 */
public class LottoGame {
	private int[] lottoList;

	
	public LottoGame() {
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();
		
		// 2. 로또 번호 만들기 (1~45)
			for (int i = 0; i < lottoList.length; i++) {
				lottoList[i] = rn.nextInt(45)+1;
				//* 중복 난수 제외
				for(int j = 0; j < i; j++) {
					if(lottoList[i] == lottoList[j]) {
						i--;
					}	
				}
			}
		sc.close();
	}
	
	
	
	
}
