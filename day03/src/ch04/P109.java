package ch04;

import java.util.Scanner;

/**
 * 
 * @author Sohee Kim
 * @date 2022-04-06
 */
public class P109 {
	// ū ������ IF�� ���� �ְ� �� �� �ɷ��� �ֵ��� ���� IF�� �ɷ����� �� ����.
	public static void main(String[] args) {
		System.out.println("Start");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input the 1st number:");
		String n1 = sc.next();
		
		System.out.println("Input the 2nd number:");
		String n2 = sc.next();
		
		
		// �Է� ���� ���ڰ� ���ڸ� ���� �ƴϸ� ����
		if(n1.length() != 1 || n2.length() != 1) {
			System.out.println("\nBye");
			sc.close();
			return;
		}
		
		// ���ڸ� �Է� �޴´�. (�� �ڸ����� ��) -> ASCII ���
		
		// "1" -> '1'
		char c1 = n1.charAt(0);
		char c2 = n2.charAt(0);
//		System.out.println((int)c);		// ASCII �ڵ带 �����ش�.
		if(!(c1 >= '1' && c1 <= '9') || !(c2 >= '1' && c2 <= '9')) {	// char�� ASCII�� ���� - �������� �� ����
																		// ||�� &&ó�� ó���� ��, �׷��� ��ġ�� �� ���� ������ �������
																		// �տ��� �־ ������.
			System.out.println("\nBye");
			sc.close();
			return;
		}
		
//		System.out.println(n1.length());	// String�� ũ�⸦ �� �� �ִ�. ���ڶ�� �ڸ���.
		System.out.printf("%s , %s �Դϴ�.\n", n1, n2);
		
		
		sc.close();
		System.out.println("\nEnd");
		
	}

}
