package ch05;
/**
 * 
 * @author noran
 *
 */
public class P151 {

	public static void main(String[] args) {
		int ar [] = {1,2,3,4,5,6,7,8,9};
		
		// �迭�� Ȧ�� ��° ������ �հ� ����� ���Ͻÿ�.
		double sum = 0.0;
		int cnt = 0;
		for(int i = 1; i < ar.length; i += 2) { // Ȧ������ �ƴ� Ȧ�� ��°�� ��
			sum += ar[i];
			cnt ++;
		}
		System.out.printf("Ȧ�� ��° ������ ��: %.0f\n", sum);
		System.out.printf("���: %.2f\n", sum/cnt);

	}

}
