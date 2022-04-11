package ch02;
/**
 * int�� double�� �������� �� �� infinity�� ������ ��.
 * @author Sohee Kim
 * @date 2022-04-06
 */
public class P47 {

	public static void main(String[] args) {
		int a = 10;
		double b = 0.0;
		
		double result = a / b;
		System.out.println(result);
		
		System.out.printf("��¥ double ��: %f\n", b);  // printf -> b��� ������� ���ڰ� �ٹаŴ�. %f = �Ǽ��� ����.
		System.out.printf("��¥ double ��: %10.2f\n", b);   // ��ü �ڸ����� 10�ڸ�, �Ҽ��� ���� 2�ڸ��� ��ƶ�
		System.out.printf("��¥ double ��: %1.50f\n", b);
		
		// ������ b�� ���� 0.00000000~ (���ѼҼ�), � ���� ���ѼҼ��� ���� �� ��� ���� ���� infinity��� �ڹٿ��� �����ߴ�.

		// format
		double b2 = 14.23543;
		System.out.printf("%n�����: %5.2f", b2);   // �ڵ� �ݿø�	- �ֿܼ� ��� (���� ȭ���� �����Ƿ�)
	}

}
