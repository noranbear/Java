package ch03;
/**
 * ������
 * @author Sohee Kim
 * @date 2022-04-05
 */
public class P64 {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		// ���׿�����
		System.out.println("���׿�����:");
		
		int aa = -a;
		// int bb = ++b; //21
		int bb = b++;
		System.out.println(bb); // 20
		System.out.println(b);  // 21
		System.out.println();
		
		// ���蹮���� ���� ������ ��.
		int c = 10;
		int d = 10;
		// int sum = c++ + ++d;   // 21??
		int sum = c++ + d++;   // 20
		System.out.println(sum);
		System.out.println(c);
		System.out.println(d);
		
		
		// ���׿�����
		System.out.println("\n���׿�����:");
		
		int result = 10 + 20;
		
		int result2 = a % b;
		System.out.println(result2);
		
		int data = 100;
		// data = data + 1;�� �Ʒ��� ���� ��. �Ʒ��� �� ������.
		data += 1;
		
		
		// �񱳿���
		System.out.println("\n�񱳿���:");
		
		int a1 = 10;
		int a2 = 20;
		
		if(a1 <= a2) {
			System.out.println("OK");
		}else {
			System.out.println("FAIL");
		}
		
		
		// ������
		System.out.println("\n������:");
		
		int b1 = 10;
		int b2 = 20;
		int d1 = 10;
		int d2 = 20;
		
		// || or
		// && and, *** &�� ���� ���� condition�� false���� �� condition�� �� ����
		
		if((b1 < b2) || (d1 > d2)) {
			System.out.println("OK");
		}else {
			System.out.println("FAIL");
		}
		System.out.println();
		
		// ���� ���� ���ɼ�!
		// && - &���� �����ս� ���鿡�� ����� ���� ���� (�� �κ��� �� Ȯ���ص� false�� ���� �� ���� ���� ���Ŀ� �������)
		if((b1 > b2) && (d1 < d2++)) {
			System.out.println("OK");
		}else {
			System.out.println("FAIL");
			System.out.println(d2);   // 20
		}
		
		// & - �̰� ���� �ٸ� ����� �⺻ (�ΰ� �� ��)
		if((b1 > b2) & (d1 < d2++)) {
			System.out.println("OK");
		}else {
			System.out.println("FAIL");
			System.out.println(d2);   // 21
		}
		System.out.println();
		
		// ! not (true or false ���忡���� ����)
		if(!(b1 > b2)) {
			System.out.println("b2 is greater than b1");
		}else {
			System.out.println("b1 is greater than b2");
		}
	
		
		// ���׿�����
		System.out.println("\n���׿�����");
		
		int e1 = 10;
		int e2 = 20;
		int result3 = 0;
		
		if(e1 <= e2) {
			result3 = 100;
		}else {
			result3 = 200;
		}
		System.out.println(result3);
		
		// ���� ���� ��Ȳ�����ڸ� �̿��Ͽ� �� �ٷ� �ٿ�����.
		int result4 = (e1 <= e2) ? 100 : 200;
		System.out.println(result4);

	}

}
