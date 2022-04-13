package ch04;
/**
 * 이중 for문 연습문제
 * @author noranbear
 * 
 */
public class P127 {

	public static void main(String[] args) {
		// 주사위를 2개 던져서 나오는 값의 합이 8이 나오는 경우 출력하시오.		// 주사위를 진짜 돌리는 게 아니라 원리만 따다가 답만 구하는 느낌.
		for(int i = 1; i < 7; i++) {
			
			for(int j = 0; j < 7; j++) {
				if((i+j) == 8) {
					System.out.printf("(%d, %d)\n", i, j);
				}
			}
		}

	}

}
