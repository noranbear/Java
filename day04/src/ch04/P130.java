package ch04;
/**
 * break���� loop ����
 * @author Sohee Kim
 * @date 2022-04-11
 */
public class P130 {

	public static void main(String[] args) {
		// i = 7 �� �������� ���� �ض�. 
		for (int i = 1; i <= 10; i++) {
			System.out.println("For Loop:" + i);
			if(i == 7) {			// �ݺ����� ���� ����
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
			s++;			// ������� ���� ������ 6���� loop�ϰ� s++�Ǿ��� ��, ����� �ɷ��� 7��° loop�� ���� x
		}

	}

}
