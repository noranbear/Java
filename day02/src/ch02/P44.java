package ch02;
/**
 * byte, int, long type ��ȯ�� ũ��
 * @author Sohee Kim
 * @date 2022-04-05
 */
public class P44 {
	
	public static void main(String[] args) {
		
		// int������ 10����, 8����, 16������ �� �� �ִ�.
		int v1 = 10;   // 10����
		int v2 = 012;   // 8���� - 10������ ���̸� ����� ���� 0�� �տ� ���̴� ��.
		int v3 = 0xA;   // 16����
		int v4 = 0x000A;   // 16����
		
		System.out.println("int���� ���� ������:");
		System.out.println(v1);
		System.out.println(v2);
		System.out.println(v3);
		System.out.println(v4);
		
		
		System.out.println("\n[byte�� +]");
		System.out.println("������� byte ũ�⺸�� ���� ���:");
		byte b1 = 10;
		byte b2 = 10;
		// Tip. '=' sign�� ������ ������ �����ʺ��� ������.
//		byte b3 = b1 + b2; // error: ������ '+' ����(16���� ����)�� �Ͼ�鼭 ������� int type�� �ȴ�. �׷��� byte(8bit)�� ���� �� �Ѵ�.
		byte b3 = (byte)(b1 + b2); // �ذ��: byte�� �߶󳻾� ������. -> �� ������ ������ 8bit�� �����Ƿ� 10�� ������. 
		System.out.println(b3);
		// **This looks work, but it just shows the result, not they actually add the values. So, ��Ģ������ �ƴϹǷ� ����.
		System.out.println(b1 + b2);
		
		
		System.out.println("\n������� byte ũ�⺸�� Ŭ ���:");
		byte b4 = 100;
		byte b5 = 100;
		byte b6 = (byte)(b4 + b5); // result: �̻��� �� -> �տ� �ִ� ���� ������ �߶������ ������.
									// ��-> 200 or 011001000 (1byte �Ѿ). -> �߶� ��, 11001000 (2's complement ������ ��ȯ���� -56).
		System.out.println(b6);
		
		
		System.out.println("\n������� int ũ�⺸�� Ŭ ���:");
		int vi1 = 1500000000;
		int vi2 = 1500000000;
//		int result = vi1 + vi2; // result: �̻��� �� -> 30���� int(8byte) �ȿ� ���� �� ���µ� int�� �⺻type�̾ �������� ���� ������ �߶������.
//		long result = (long)(vi1 + vi2); // �ȵȴ�.
		long result = (long)vi1 + (long)vi2; // ����
		System.out.println(String.format("%,d", result)); ?? 0�� ���� ����. ������ ������ �װ�?
		
		// ������� ���� ��, int�� 21������ �ۿ� �� �ֱ� ������ �ʹ� �۴�. long�� �� ���� ������, ����Ÿ���� long�� �Ҽ��� ���ϸ� ǥ���� �� ����.
		// �׷��� �Ǽ����� ����Ѵ�.
		
		long vi3 = 15000000000L; // int�� �⺻Ÿ���̱� ������ 21���� �Ѿ�� ���� �� �� ����. long�� �� ���, �ڿ� L�� �ٿ��ָ� �� �κ��� �ذ�ȴ�.
		long vi4 = 15000000000L;
		long result2 = vi3 + vi4;
		
		System.out.println(result2);
	}

}
