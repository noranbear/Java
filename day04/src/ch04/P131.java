package ch04;
/**
 * continue�� break �̻�� loop ����
 * @author Sohee Kim
 * @date 2022-04-11
 */
public class P131 {

	public static void main(String[] args) {
		// i�� ¦���϶��� ��� �Ͻÿ�
		for (int i = 1; i <= 10; i++) {
			if(i%2 == 0) {
				System.out.println("For Loop:" + i);
			}
		} // end for
		
		System.out.println("------------------");
		
		// while
		int s = 1;
		while(s <= 10) {
			if (s%2 == 0) {
				System.out.println("While Loop:" + s);	
			}			
			s++;
		}

	}

}
