package ch02;
/**
 * int, double type�� ũ��� ��ȯ
 * @author Sohee Kim
 * @date 2022-04-05
 */
public class P46 {

	public static void main(String[] args) {
//		double d1 = 100000000000000000000000000000; // error: �Ǽ��̱� ������ .0�� �ڿ� �ٿ��� �Ѵ�. (int ũ�⵵ �Ѿ�� int�� double��
													//�ڵ���ȯ�Ǵ� �͵� ����.
		double d1 = 100000000000000000000000000000.0;
//		float f1 = 1000000000000000000000000.0; // �� ������ ũ��� �� ����.
		// ���� ��������� ũ�⵵ double Ÿ������ ���� ���δ�. (��ȭ ��)
		// ����Ʈ ���ӷ� �� (long), ���� HP (int)...
		double d2 = 10;   // �ڵ� Ÿ��ĳ����. �Ǽ����� ���� ������ ������ �����ؼ� ����ִ� ���� �����Ӱ� �����ϴ�.
		
		System.out.println("double -> integer type casting:");
		int a = (int)10.1;   // ū �ſ��� ���� �Ŵ� ĳ������ �ؾ� �Ѵ�.
		int b = (int)1000000000000.0; // result: �߸��� ��. �߶� ��������.
		System.out.println(a);
		System.out.println(b);
		
//		double d3 = 10000000000; // error: int������ �Ѿ��.
		double d3 = 10000000000.0;

	}

}
