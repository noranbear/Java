package p576;

/**
 * MainThread App���� ��Ƽ�� ����� ù���� Thread
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 25. ���� 10:03:51
 * @version 1.0
 */
public class MyThread1 extends Thread {

	@Override
	public void run() {
		// 1. 0���� 100�� �ֿܼ� ����.
		int i = 0;
		while(i <=100) {
			i++;
			// ���������� �ϳ� �޴� �Ͱ���
			System.out.println("MyThread1 "+ i);
			try {
				Thread.sleep(1000);			// �ӵ�����: 1��
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
	}

}
