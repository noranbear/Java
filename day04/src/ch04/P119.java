package ch04;
/**
 * for loop & while loop
 * @author Sohee Kim
 * @date 2022-04-11
 */
public class P119 {

	public static void main(String[] args) {
		
		System.out.println("Start....");
		
		// 1���� 10���� �ݺ��Ͽ�
		for (int i = 1; i <= 10; i++) {
			System.out.println("For ...." + i);
		}
		
		System.out.println("End....");
		
		int s = 1;	// ������
		while(s <= 10) {
			System.out.println("while ...." + s);		// ������ ������ ������ �Ͼ�� �Ѵ�.
			s++;	// ����
		}	// end while
	}

}
