package ch04;
/**
 * ���� for�� ��������
 * @author noranbear
 * 
 */
public class P127 {

	public static void main(String[] args) {
		// �ֻ����� 2�� ������ ������ ���� ���� 8�� ������ ��� ����Ͻÿ�.		// �ֻ����� ��¥ ������ �� �ƴ϶� ������ ���ٰ� �丸 ���ϴ� ����.
		for(int i = 1; i < 7; i++) {
			
			for(int j = 0; j < 7; j++) {
				if((i+j) == 8) {
					System.out.printf("(%d, %d)\n", i, j);
				}
			}
		}

	}

}
