package p576;

/**
 * ���α׷� �ȿ� main�̶�� ���μ��� ����ǰ� ������.
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 25. ���� 9:38:21
 * @version 1.0
 */
public class MainApp {

	public static void main(String[] args) {
		System.out.println("Start");
		// 1. 0���� 300���� ȭ�鿡 �����.
		int i = 0;
		while(i <= 300) {
			System.out.println(i);
			i++;
			
			try {
				Thread.sleep(1000);			 // �����尡 ����� ��, 1�� �Ŀ� �����϶�. (1�� ���� �����)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("End");
	}

}
