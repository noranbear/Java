package ch04;
/**
 * switch��
 * @author Sohee Kim
 * @2022-04-11
 */
public class P117 {

	public static void main(String[] args) {
		String a = "10";	// Switch�� ��: String, ���� ���� Ÿ���� ����, �Ǽ� Ÿ�� �Ұ���.
		switch (a) {   // ������ ���� �ʴ´�.
		case "10": 
			System.out.println("ū��");
			break;	// switch�� ������.
		case "5":
			System.out.println("�߰���");
			break;
		case "1":
			System.out.println("������");
			break;
		default:
			System.out.println("�Է¿���");
			break;
		}	// end switch
		System.out.println("End....");

	}

}
