package ch05;

import java.util.Arrays;

/**
 * �迭 ����, �迭�� �� �����ֱ�, for loop�� ����� ���� 
 * @author noran
 *
 */
public class P149 {

	public static void main(String[] args) {
		int a = 10;
		
		// int ar [] = {10, 11, 12, 13}; //�̷������� ���� ���������� ������ ���̱� ������ �������� �� ������ �ʴ´�.
		int ar [] =	new int [4]; // �迭(array ����) -> reference type/  [] ar - �̷��� ���� ����
							// �迭�� null�̸� �ƹ��͵� ����(nullpointerexception). ������ ÷�� ������ ���� ��
		ar[0] = 10;
		ar[1] = 11;
		ar[2] = 12;
		ar[3] = 13;
		
		System.out.println(a);
		System.out.println(ar); // address
		System.out.println(Arrays.toString(ar));  // array ���� ������ �� �ֵ�
		
		// values in array
		for(int i = 0; i < ar.length; i++) {	// length �ڿ� no ����
			System.out.println(ar[i]);
			
		}

	}

}
