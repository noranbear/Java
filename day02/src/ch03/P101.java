package ch03;
/**
 * if-statement�� ���� �����ڸ� �̿��Ͽ� if-statement�� �����ϴ� ���.
 * @author Sohee Kim
 * @date 2022-04-05
 */
public class P101 {

	public static void main(String[] args) {
		int sum = 86;
		char result = 0; // local variable�� �ʱ�ȭ�� ���Ѽ� ����ض�, char�� �������̱� ������ 0���� �ʱ�ȭ����.
		
		// 90 �̻��̸� 'A'
		// 80 �̻��̸� 'B'
		// 80 �̸��̸� 'D'
//		if(sum >= 90) {
//			result = 'A';
//		}else if(sum >= 80) {
//			result = 'B';
//		}else {
//			result = 'D';
//		}
		
		// ���� �����ڷ� ���� statement�� �����Ͻÿ�.
		result = (sum >= 90) ? 'A': (sum >= 80) ? 'B': 'D';
		System.out.println(result);
		
		
	}

}
