package ch04;

import java.util.Scanner;
//import java.lang.Math;	// for Math.pow  -- �ʹ� ���� �Ἥ Default�� �Ǿ ���� import�� ���� �ʾƵ� ��.
//import java.lang.*; // ���� lang���� ��� ���̶�� ��.
/**
 * Scanner�� ����� ���ǹ��� �������
 * @author Sohee Kim
 * @date 2022-04-06
 */
public class P108 {

	public static void main(String[] args) {
//		Math.pow(0, 0);		// import ����.
		
		System.out.println("Start ....");
		
		
		Scanner sc = new Scanner(System.in);	// import ����.
		System.out.println("Input Number: ");
		String num = sc.next();
		int nm = Integer.parseInt(num);					// String -> int
		
		// �Է��� ���ڰ� 0�̸� ���α׷� ����, �׷��� ������ ���
		// 1���� 10������ ���ڰ� �ƴϸ� ����
		if(!(nm >= 1 && nm <= 10)) {		// or (nm == 0 || (nm < 1 || nm > 10)
//			System.exit(0);		// ���α׷� ����
			System.out.println("Bye");
			sc.close();
			return;		// main�� �� }���� ������.
		}
		
		// printf (%d, %s, %f) ����, ����, �Ǽ�
		System.out.printf("�Է��� ���� %d�̴�.\n", nm);
		
		// Ȧ������ �ƴ����� ���Ͻÿ�.
		if(nm%2 == 0) {
			System.out.printf("�Է��� �� %d��/�� ¦���̸� ", nm);
		}else {
			System.out.printf("�Է��� �� %d��/�� Ȧ���̸� ", nm);
		}
		
		// ��(7�̻�), ��(3�̻�), ��(3�̸�) �Դϴ�.
		if(nm >= 7) {
			System.out.println("����̴�.\n");
		}else if(nm >= 3) {
			System.out.println("�߼��̴�.\n");
		}else {
			System.out.println("�Ҽ��̴�.\n");
		}
		// ���� if else statement�� ���׿����ڷ� ��ȯ�Ͻÿ�.
		String r = ""; // �ʱ�ȭ
		r = (nm >= 7) ? "���" 
		  : (nm >= 3) ? "�߼�" 
		  : "�Ҽ�";					// if���� ���� �ӵ��� �������� ���� �ƴ�.
		System.out.println(r);		// �������� ������ �� ���� ���ذ� �� ���� ����.
		

		sc.close();
		System.out.println("End ....");
	}

}
