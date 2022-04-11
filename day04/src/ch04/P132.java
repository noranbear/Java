package ch04;
/**
 * continue�� loop ����
 * @author Sohee Kim
 * @date 2022-04-11
 */
public class P132 {

	public static void main(String[] args) {
		// i�� ¦���϶��� ��� �Ͻÿ�
		for (int i = 1; i <= 10; i++) {
			if(i%2 == 1) {
				continue; // loop ���� ���� ���� skip
			}
			System.out.println("For Loop:" + i);
		} // end for
		
		System.out.println("------------------");
		
		// while
		int s = 1;
		while(s <= 10) {		// �̷��Ը��ϸ� s���� �� �ٲ��� ���� �Ұ�.
			if (s%2 == 1) {
				s++;		// Ȧ���� �� s++
				continue;
			}			
			System.out.println("While Loop:" + s);
			s++;	// ¦���� �� s++
		}

	}

}
