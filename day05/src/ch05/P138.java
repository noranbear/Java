package ch05;
/**
 * �޸�
 * @author noran
 *
 */
public class P138 {

	public static void main(String[] args) {
		int a = 10;
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		System.out.printf("%d %s", a, s1);
		String s5 = null;		// Reference type�� �ʱⰪ
		String s6 = "";			// String type�� �̷��� �ʱ�ȭ �ص� �ȴ�. (����)
		
		System.out.println(s5);
		
		char c = s1.charAt(1);
		System.out.println(c);
		
		int len = s2.length();
		System.out.println(len);
		
		String ns = s3.toUpperCase();
		System.out.println(ns);
		s1.toUpperCase();
		System.out.println(s1); // s1���� uppercase�� �� �ٲ��. => �� �� ������� String ��ü�� �ٲ� �� ����. ABC�� �ϳ��� ���� ���������
		
//		System.out.println(s5.length());	// nullpointerException ---> null = �ƹ��� �ּҰ� ������ ���� String.
		System.out.println(s6); // �ƹ��͵� �� ���� - �����̾
		
		
		
		

	}

}
