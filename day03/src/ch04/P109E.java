package ch04;

import java.util.Scanner;

/**
 * Workshop: �Է� -> ���� -> ������� (���� ���� �����ϱ�) - ��� �ڹ��� �ڵ� ����� �ƴϴ�;; �̰� ����������... �ڹٰ� �ƴϿ�, ��ü�������� �Ѿ���� �ڹٽ���.
 * @author Sohee Kim
 * @date 2022-04-06
 */
public class P109E {

	public static void main(String[] args) {

		double num1 = 0.0;
		double num2 = 0.0;
		double result = 0.0;
		Scanner sc = new Scanner(System.in);
		
		// 1. ���� 2���� �����ڸ� �Է� �޴´� (3������ �Է� �޴´�) (+, -, / , x)
		System.out.println("Enter the 1st number: ");
		String snum1 = sc.next();
		
		System.out.println("Enter the 2nd number: ");
		String snum2 = sc.next();
		
		System.out.println("Enter an operator (+, -, /, x): ");
		String op = sc.next();
		
		// OP ���� - ö�뺸��
		if (op.length() > 1 || (!(op.equals("+")) 
							&& !(op.equals("-")) 
							&& !(op.equals("/")) 
							&& !(op.equals("x"))) ) {
			
				System.out.println("Your input for the operator is wrong. \nBye");
					sc.close();
					return;
				}
				
		System.out.printf("You entered %s, %s, and %s.\n", snum1, snum2, op);  // double�� �� �� ���� String���� �Է��ϸ� ������ �Է��� ���
		   																		// ���� ���̴�.
		
		// ���ڸ� �Է� �޴´�. (����, ���ڸ��� ���ڰ� ���ڸ��� ���ڸ�?) => loop�� ����ؾ� �� ��.('���ܻ���'�� ���Ŀ� ������ ���̴�)
		try {	// �����߻�
			num1 = Double.parseDouble(snum1);
			num2 = Double.parseDouble(snum2);
		}catch(Exception e) {		// ��Ƽ� ó��.	
			System.out.println("\nWrong Input. \nPlease enter a number only. \nOk Bye...");
			sc.close();
			return;
		}
		
		// op�� �� �� �̻����� input�� �ŵ�, ���⿡�� �ɷ���.
		if(op.equals("+")) {
			result = num1 + num2; 
		}else if(op.equals("-")){
			result = num1 - num2;
		}else if(op.equals("/")) {
			result = num1 / num2;
		}else if(op.equals("x")||op.equals("X")){
			result = num1 * num2;
		}else {
			System.out.println("Your input is wrong. \nBye");
			sc.close();
			return;
		}
		
		// 2. ����� ����� ��� �Ѵ�. ��, �Ҽ��� ���ϱ��� ��� (�Ҽ��� 3�ڸ����� �ݿø�)
		System.out.printf("������� %.2f�� ", result);
		
//		// 3. ����� ����� �������� ������� ��� �Ѵ�.
//		String str = String.valueOf(result);		// double�̴ϱ� ���� �̷� �ʿ���� 0�̶� �������� �ƾ���...
//		char sign = str.charAt(0);
//		if(sign == '-') {
//			System.out.printf("�����̸� ", result);
//		}else {
//			System.out.printf("����̸� ", result);
//		}
		
		// 3���� ���� ����
		String str = "";
		str = (result < 0) ? "����" : "���";
		System.out.printf("%s�̸� ", str);
		
		// 4. ����� ��� ���� 10�̻��̸� ū��. 5�̻��̸� �߰���, 5�̸��̸� ������ ���
		// println ���� String�� ��ô�.
		String str2 = "";
		if(result >= 10) {
			str2 = "ū�� �Դϴ�.";
//			System.out.println("ū�� �Դϴ�.");
		}else if(result >= 5) {
			str2 = "�߰��� �Դϴ�.";
//			System.out.println("�߰��� �Դϴ�.");
		}else {
			str2 = "������ �Դϴ�.";
//			System.out.println("������ �Դϴ�.");
		}
		System.out.println(str2);
		
		
		sc.close();
		
//		// ����: "11.3" �Ҽ����� intȭ �Ǵ��� Ȯ�� -> compile error --> �翬�� �ȵǳ� ���������� �Ҽ����� �ִµ� int�ϸ� ���.. 
												// ==> double, float���� ����
//		// ���� 2: "-11"�� intȭ �Ǵ��� Ȯ�� -> ����.
//		String num5 = "-11";
//		int a = Integer.parseInt(num5);
//		System.out.println(num5);
		
	}

}
