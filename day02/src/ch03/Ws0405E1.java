package ch03;
/**
 * Extra possible ways of Workshop2 using Math class (���˹��� �߻�->�ذ�)
 * @author Sohee Kim
 * @date 2022-04-05
 *
 */
public class Ws0405E1 {

	public static void main(String[] args) {
		
		// ���ΰ� 5 ���ΰ� 7�� �����ﰢ���� ���� ���̸� ���Ͻÿ�. ��: 8.60233~
		double w = 5;	// width
		double h = 7;	// height
		
		// * !!! Result�� ����: ������ �Ҽ��� �ڸ��� 0�϶� 2���� ����� 8.6���� 0�� ������ �ʰ� �ȴ�.
		System.out.println(Math.round(Math.hypot(w, h)*100)/100.0);
		// �ذ�
		System.out.format("%.2f%n", (Math.round(Math.hypot(w, h)*100))/100.0);
		System.out.format("%.2f", Math.hypot(w, h));

	}

}
