package ch04;

import java.util.Random;	// java.lang ��Ű�� ���� ���� import�ؾ� �Ѵ�
/**
 * switch 02 wiht random number
 * @author Sohee Kim
 * @date 2022-04-11
 */
public class P118 {

	public static void main(String[] args) {
		Random r = new Random();	// Random
//		int n = r.nextInt(3);		// 0~2
		int n = r.nextInt(3) + 1;	// 1~3
		System.out.println(n);
		
		// Switch���� ����ϴ� �� (authentication �� �� switch���� �����ϴ�.)
		switch (n) {
		case 1:			// 1��
			System.out.println("�����");
			break;						// break�� ������ ���� case�� �� ������.
		case 2:			// 2��
			System.out.println("��Ź��");
			break;
		case 3:			// 3��
			System.out.println("�ڵ���");
			break;

		default:
			break;
		}
	}

}
