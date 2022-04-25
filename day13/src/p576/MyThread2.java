package p576;

/**
 * MainThread App���� ��Ƽ�� ����� �ι�° Thread
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 25. ���� 10:04:15
 * @version 1.0
 */
public class MyThread2 implements Runnable{

	@Override
	public void run() {
		int i = 0;
		while(i <=100) {
			i++;
			// ���������� �ϳ� �޴� �Ͱ���
			System.out.println("MyThread2 "+ i);
			try {
				Thread.sleep(1500);			// �ӵ�����: 1.5�� - ��Ʈ��ũ�� ��������� ����
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
	}

}
