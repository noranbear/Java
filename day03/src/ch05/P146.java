package ch05;
/**
 * �񱳹�
 * @author Sohee Kim
 * @date 2022-04-06
 */
public class P146 {

	public static void main(String[] args) {
		
		// int ��
		int a = 10;
		int b = 20;
		if(a > b) {
			System.out.println("OK");
		}else {
			System.out.println("No");
		}
		
		// String ��
		System.out.println("\nCompare Strings: ");
		
		String s1 = "abc";
		String s2 = "abc";
		
		if(s1 == s2) {	// �ּ� ��
			System.out.println("Equal Reference..");
		}
		
		if(s1.equals(s2)) {	// **�� ��
			System.out.println("Equal String..");
		}

	}

}
