package ch05;
/**
 * String �������� ���� ���� ���� ������ ������ (��Ʈ ����)
 * @author Sohee Kim
 * @date 2022-04-06
 */
public class P147 {

	public static void main(String[] args) {
		String s1 = "ABC";
		String s2 = new String("ABC");	// �̷��� String�� ���� ���� �ִ�.
		String s3 = "ABC";
		String s4 = new String("ABC");
		
		if(s1 == s2) {	// �ּ� �� --> �ٸ��Ƿ� ���� �ʴ�.
			System.out.println("Equal Reference..");
		}
		
		if(s1.equals(s2)) {	// **�� �� --> ���� �����Ƿ� �ٸ� ABC�� ����Ű�� �ִٰ� �ؼ� 
			System.out.println("Equal String..");
		}


	}

}
