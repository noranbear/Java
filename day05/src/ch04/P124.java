package ch04;
/**
 * ���� for���� �̿��Ͽ� ������ ��Ÿ����
 * + �������� ���������� Ư���о� ���� �������� ���� ������� �ʴ´�. �� �� ���ư��� - 2����, �� �� - 3����
 * @author noranbear
 * @date 2022-04-12
 */
public class P124 {

	public static void main(String[] args) {
		
		outter:	// �̸��� ���ϴ� ��� �ٲ� �� �ִ�
		for (int i = 2; i < 10; i++) {		// i ���� ���������� ���� ���� ���� �ǹ�- 2x3=6�� 2 2x4=8�� 2
			// ¦���ܸ� ��� �ʹ�.
			if(i%2 == 1) {
				continue;
			}
			System.out.println(i + "�� ���� -------");
			
			// 5�ܿ��� ������ �ʹ�.
//			if(i == 6) {
//				break;
//			}
			
			for (int j = 1; j < 10; j++) {		
				// ���28�� ������ ���� �����. // case1) 4�ܸ� �����. -> break;�� �� ������ ����. 
				if((i*j) == 28) {
					break outter;	// outter�� ����� ���� ��ü�� ������. case2)28�� �Ǹ� �� �̻� ������ �ȵǰ� ����
				}
				System.out.printf("%d x %d = %d\t", i,j,(i*j));  // \t = tab
				
			}
			System.out.println("~~~~~~~~~~~~~~");
		}

	}

}
