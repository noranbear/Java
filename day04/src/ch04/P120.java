package ch04;
/**
 * Workshop using for loop
 * @author Sohee Kim
 * @date 2022-04-11
 */
public class P120 {

	public static void main(String[] args) {
		// 1~10������ ���� ���Ͻÿ�
		int sum = 0;
		int count = 0;
		for(int i = 1; i < 11; i++) {
			sum += i;
			count++;
		}
		System.out.println(sum);
		System.out.println(count);	// 10
		System.out.println(sum/count);	// ���
		
		System.out.println("----------------------------------");
		
		// while loop��
		int s = 1;
		int sum2 = 0;
		
		while(s < 11) {
			sum2 += s;
			s++;
		}
		System.out.println(sum2);
		
		// 1~ 10������ ���� ����� ���Ͻÿ�.
		System.out.println(sum2/s);
		System.out.println(s);	// result: 11, while���� s�� 10�϶�, �۵� �� s++�� ���־��� ����.
		System.out.println(sum2/(s-1)); // SO, s-1�� �ؾ� s�� 10�� �ȴ�. (double�� �ƴϱ� ������ ��Ȯ�� ���� �� ����)
	}

}
