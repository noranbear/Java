package ch03;
/**
 * String - ����, �Ǽ��� ��ȯ.
 * @author Sohee KIm
 * @date 2022-04-05
 */
public class P86 {
	
	public static void main(String[] args) {
		String str = "100";
		String str2 = "��";  // �̰��� ��� �ذ�����?
		String str3 = "NaN";  // "NaN"�� Ư�� ���̽� = not a number
		char c = 'A';
		
		int a = c;   // ����
		System.out.println(a);
		
//		int a = str; �Ұ���
		int b = Integer.valueOf(str); // String�� int�� �ٲ� �� �ִ�. (parseInt, valueOf)
		//int d = Integer.parseInt(str2);
		
		int result = b * 100;
		
		double e = Double.valueOf(str3); // �Ǽ��� NaN �ֱ�� ����
		double result2 = 0.0;
		
		if(Double.isNaN(e)) { // is Not a Number (NaN���� �� �� �ִ� ��� ����)
			System.out.println("�Է� ����");
		}else {
			result2 = a * 100;
		}
		
		// System.out.println(d);
		System.out.println(result);
		System.out.println(result2);
		System.out.println(e);
	}

}
