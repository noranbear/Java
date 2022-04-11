package ch02;
/**
 * byte�� int, float�� double, int�� double ������ ���� ����� ��Ģ����
 * @author Sohee Kim
 * @date 2022-04-05
 */
public class P60 {

	public static void main(String[] args) {
		byte b1 = 10; 
		byte b2 = 100;
//		float f1 = 2.5; // double�� �⺻�̾ double ���̵ȴ�. longó�� ���� float�� F�� �ٿ���� �Ѵ�.
		float f1 = 2.5F;
		double d2 = 2.5;
		
		System.out.println("byte - int:");
//		byte bb = b1 + b1;   //intȭ
//		byte bb = (byte)b1 + (byte)b1; // �ȵǳ�?? -> *byte�� ���¿��� ��Ģ������ �ϸ� intȭ�ؼ� byteŸ�Կ� �� ���� �Ѵٴϱ�~
		byte bb = (byte)(b1 + b1);  // ������ ��������, �� ���� �ٸ� ���� �־��� ��, �� �´� ��찡 ����.
		byte bb2 = (byte)(b2 + b2); //�߸��� ��
		int result = b1 + b1;   // ����
		
		System.out.println(bb); // �� �ǳ�?
		System.out.println(bb2); // �ȵǴ� �ſ���.
		System.out.println(result);
		
		
		System.out.println("\nfloat - double:");
		float ff = 5 + f1;
//		float ff2 = 5000000000000000000000000 +f1;   // error. �ڿ� f�� �ٿ���
		double dd = 5 + d2;
		double dd2 = 500000000000000000000000000.0 +d2;        // ���� ���ε� �Ҽ����� ������ double�� �Ŷ� �����ؼ� floatŸ���� ��, ����.
																// ū ���̸� double�� �Ŷ� �����ؼ�(�Ҽ��� ���� ���x) floatŸ���� ��, ����.
		System.out.println(ff);
		System.out.println(dd);
		
		
		System.out.println("\nint + double:");
		//int result2 = 100 + d2; // error: ��Ģ���꿡�� �Ǽ��� ������ ������ �Ǽ� ����.
		int result2 = 100 + (int)d2;   // �̷� ��� �Ҽ��� ������ ���� ��������, d2�� int Ÿ���� ������ �Ѿ�� ���̸� �ȵȴ�.
		System.out.println(result2);

	}

}
