package ch04;
/**
 * 이중 for문을 이용하여 2차원 정방 행렬 만들기
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
