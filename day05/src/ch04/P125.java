package ch04;
/**
 * ���� for���� �̿��Ͽ� 2���� ���� ��� �����
 * @author noranbear
 * @date 2022-04-12
 * @version 1.0
 */
public class P125 {

	public static void main(String[] args) {
		
		
		for (int i = 0; i < 5; i++) {	
			
			System.out.println("--------------------------------------------------------");
			System.out.print("|  ");
			for (int j = 0; j < 5; j++) {		
				System.out.printf("(%d, %d)  ", i, j);
				System.out.print("|  ");
			}
			System.out.println();
			
		}
		System.out.println("--------------------------------------------------------");

	}

}
