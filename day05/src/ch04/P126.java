package ch04;
/**
 * ���� while���� �̿��Ͽ� 2���� ���� ��� �����
 * @author noranbear
 * @date 2022-04-12
 * @version 1.0
 */
public class P126 {

	public static void main(String[] args) {
		
		int s = 0;
		while(s < 5) {	
			
			System.out.println("--------------------------------------------------------");
			System.out.print("|  ");
			s++;
			
			int r = 0;
			while(r < 5){		
				System.out.printf("(%d, %d)  ", s, r);
				System.out.print("|  ");
				r++;
			}
			System.out.println();
			
		}
		System.out.println("--------------------------------------------------------");

	}

}
