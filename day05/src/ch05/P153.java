package ch05;

import java.util.Random;

/**
 * ������ �迭
 * @author noran
 *
 */
public class P153 {

	public static void main(String[] args) {
		
//		int ar [] = new int[];		// 1���� �迭
		
		// int ar[][] = new int[3][3]; // �ؿ� 4�ٰ� ���� ��.
		int ar [][] = new int [3][];	// ������ �迭 - ù �ڽ��� ��
		ar[0] = new int[3];		// �׻� ���� ���� ��������� ������ �࿡ ���� ���������.
		ar[1] = new int[3];
		ar[2] = new int[3];		// 2���� �迭
		
		// ���� �־��.	// �������� �̷� �� ����.
//		ar[1][2] = 100;
//		ar[0][1] = 200;
		
		Random ran = new Random();
		// ���� for���� �̿��Ͽ� ������ �迭�� �� ����ֱ�
		// 0
		// 1
		// 2
		for (int i = 0; i < ar.length; i++) {
			
			// 0, 1, 2
			for (int j = 0; j < ar[i].length; j++) {
				ar[i][j] = ran.nextInt(9)+1;
				System.out.print(ar[i][j]+ "\t");
			}
			System.out.println();
		}
//		System.out.println(Arrays.toString(ar));	// ������
		
		// for���� �̿��Ͽ� �հ� ����� ���Ͻÿ�.
		double sum = 0.0;
		int cnt = 0;
		for(int i = 0; i < ar.length; i++) {		// ar.length: ù ���� ����� �˷��� - �޸� �׸����� �����ϸ� ���� ar�� ���� �Ǿ��ִ� �ּҰ� ����Ű�� 1��(3��)�� ������.
													// ar.length = ar[][j].length�� ���̴� ���� �츮�� j�� ���� �� �� �ִٸ�.
			for(int j =0; j < ar[i].length; j++) {
				sum += ar[i][j];
				cnt ++;
			}
		}
		System.out.printf("��: %.0f\n���: %.2f\n", sum, sum/cnt);
		System.out.printf("���2: %.2f\n", sum/(ar.length *ar[0].length));
		

	}

}
