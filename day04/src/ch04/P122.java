package ch04;

import java.util.Scanner;

/**
 * while loop�� ����� Scanner�� ���� ������ �հ� ����� ���ϴ� Ȱ�빮��.
 * @author Sohee
 * @date 2022-04-11
 */
public class P122 {

	public static void main(String[] args) {
		// 1. Scanner�� �̿��Ͽ� 1~99������ ������ �Է� �޴´�.
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number (1~99): ");
//		int num = s.nextInt();
		String snum = s.next();			//�� ���� string? -> ������Ʈ���� �����鿡�� �޴� ������ ���� �� String�̱� ����.
		
		// 2. ������ ����� Bye ���α׷� ����
		int num = 0;	// �ۿ��ٰ� ���� ���ϸ� num�� ���÷� �νĵǾ� �ٱ����� �ν� �Ұ�.
		try {			// ���� ���� ���� ���� exception�� ����� �߿��ϰ� ���� �ڵ��� ���� �����Ѵ�.
			// ��
			num = Integer.parseInt(snum);
			// 2 ~ 99
			if(num < 1 || num > 99) {				// return �� �� �ߺ��ؼ� ���� ���� ��������, ���� ��� �ѿ����� �̷��� ����.
				System.out.println("Bye num ...");
				s.close();
				return;
			}
		}catch(Exception e) {
			System.out.println("Bye string");
			s.close();
			return;		// �� function�� ������ �׸��ΰ� ���⼭ ������� ��
		}
		
		// 3. 1���� �Է� ���� �������� �հ� ����� ��� �Ͻÿ� (while)
		int i = 1;
		int sum = 0;
		while(i <= num) {
			sum += i;
			i++;
		}
		System.out.printf("����: %d\n", num);
		System.out.printf("��: %d\n", sum);
		System.out.printf("���: %.1f", (double)sum/(i-1));
		
		s.close(); // pipe ����
	}

}
