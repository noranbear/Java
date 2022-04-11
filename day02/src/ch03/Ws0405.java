package ch03;
/**
 * Workshop2 using Math class (���˹��� �߻�->�ذ�)
 * @author Sohee Kim
 * @date 2022-04-05
 */
public class Ws0405 {

	public static void main(String[] args) {
		
		// ���ΰ� 5 ���ΰ� 7�� �����ﰢ���� ���� ���̸� ���Ͻÿ�. (�Ҽ��� ���ڸ����� �ݿø��Ͻÿ�.) ��: 8.60
		double a = 5;	// width
		double b = 7;	// height
		double c = 0;	// hypotenuse
		
		a = Math.pow(a, 2);   // power
		b = Math.pow(b, 2);
		
		c = Math.sqrt(a + b);   // square root
		
		System.out.println(c);	// Java���� ���Ƿ� ���� �Ҽ��� ������ �ݿø�.
		System.out.println(Math.round(c)); // returns the closest long.
		
		// * !!! Result�� ����: ������ �Ҽ��� �ڸ��� 0�϶� 2���� ����� 8.6���� 0�� ������ �ʰ� �ȴ�.
		System.out.println(Math.round(c*100)/100.0);   // round  // �ڿ��� �Ҽ��� ���̴� ����: intȭ�� ���ϱ� ����.
		
//		System.out.printf("%.2f", Math.round(c)); // compile error- Math.round������ c�� long�� �Ǿ decimal number�� ����
													// format�� �� �� ����.
		// �ذ��
		System.out.printf("%.2f", c);
		
	}

}
