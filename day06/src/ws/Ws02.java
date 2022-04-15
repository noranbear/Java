/**
 * 
 */
package ws;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Lotto Game
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 14. ���� 3:07:16
 */
public class Ws02 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rn = new Random();
		//* ���ʽ�??
		
		// 1. int 6 ������ �迭 ����� 
		int ar[] = new int[6];
		int user[] = new int[6];
		int num = 0;
		
		// 2. �ζ� ��ȣ ����� (1~45)
		for (int i = 0; i < ar.length; i++) {
			ar[i] = rn.nextInt(45)+1;
			//* �ߺ� ���� ����
			for(int j = 0; j < i; j++) {
				if(ar[i] == ar[j]) {
					i--;
				}	
			}
		}
		
		// 3. �������� ��ȣ �ޱ� (1~45)
		for(int i = 0; i < ar.length; i++) {
			
			System.out.printf("Guess a number%d: ",i+1);
			String snum = sc.next();
			
			//* ���� ���� ���� ����
			try {
				num = Integer.parseInt(snum);
			}catch(Exception e) {
				System.out.println("Input a number.\n");
				i--;
				continue;
			}
			user[i] = num;
			
			//* �ߺ� ��ȣ �Է� ����
			for(int j = 0; j < i; j++) {
				if(user[i] == user[j]) {
					System.out.println("Input a different number.\n");
					i--;
					continue;
				}
			}
			
			//* ���� ���� ���� ���� (1~45)
			if(num < 0 || num > 45) {
				System.out.println("Input a number in the range.\n");
				i--;
				continue;
			}
			
		}
		
		// 4. ���� ��ȣ ���ϱ�
		int correct = 0;
		for (int i = 0; i < user.length; i++) {
			if(ar[i] == user[i]) {
				correct++;
			}
		}

		// 7. ��� ����
		System.out.println(Arrays.toString(ar));
		System.out.println(Arrays.toString(user));
		System.out.printf("����� %d���� ���߼̽��ϴ�.\n", correct);
		
		// 6. ��� ���� (1��-6��, 2��-5��, 3��-4��, 4��-3��, 5��-2��, ��÷ <)
			if(correct == 6) {
				System.out.println("�����մϴ�! 1���̽ʴϴ�~!!!");
			}else if(correct == 5) {
				System.out.println("�����մϴ�! 2���̽ʴϴ�~!");
			}else if(correct == 4) {
				System.out.println("�����մϴ�! 3���̽ʴϴ�~");
			}else if(correct == 3) {
				System.out.println("�����մϴ�. 4���̽ʴϴ�~");
			}else if(correct == 2) {
				System.out.println("�����մϴ�. 5���̽ʴϴ�.");
			}else{
				System.out.println("��..��÷..��");
			}
			
	sc.close();		
	}

}
