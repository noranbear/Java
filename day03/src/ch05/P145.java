package ch05;
/**
 * String Ÿ�԰� ������� (��Ʈ ����)
 * @author Sohee Kim
 * @date 2022-04-06
 */
public class P145 {

	public static void main(String[] args) {
		String s1 = "ABC";
		String s2 = "ABC";
		String s3 = s2.toLowerCase();   // �ҹ���ȭ   // .�� ��: s2�� �ּҰ��� �����ض�. String�� �� �� �޸𸮿� ���� �ٲ� �� ����.
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		char c = s3.charAt(0);		// �ش� index�� �ִ� character�� �����Ѵ�.
		System.out.println(c);
		

	}

}
