package ch04;
/**
 * 
 * Multiplication table example
 * (+) �������� ���������� Ư���о� ���� �������� ���� ������� �ʴ´�. �� �� ���ư��� - 2����, �� �� - 3����
 * New concepts: break outter, \t
 * 
 * @author noranbear
 * @date 2022-04-12
 */
public class P124 {

	public static void main(String[] args) {
		
		outter:								// �̸��� ���ϴ� ��� �ٲ� �� �ִ�.
		for (int i = 2; i < 10; i++) {		// i ���� ���������� ���� ���� ���� �ǹ�- 2x3=6�� 2 2x4=8�� 2
			// *¦���ܸ� ��� �ʹ�.
			if(i%2 == 1) {
				continue;
			}
			// *5�ܿ��� ������ �ʹ�.
//			if(i == 6) {
//				break;
//			}
			System.out.println(i + "�� ���� -------");
			
			for (int j = 1; j < 10; j++) {		
				// *���28�� ������ ���� �����.  
				if((i*j) == 28) {
					break outter;			// case1) break; -> 28���� 4�ܸ� ���߰� �� ���� ���� �������. => break;�� �ش� ����(break�� ������)�� ����.
											// case2) break outter; -> 28�� �Ǹ� �� �̻� ������ �ȵǰ� ��ü����(���� outter: ���� ����)���� ����.
				}
				System.out.printf("%d x %d = %d\t", i,j,(i*j));  	// \t = tab
				
			}
			System.out.println("~~~~~~~~~~~~~~");
		}
	}
}
