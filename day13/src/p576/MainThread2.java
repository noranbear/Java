package p576;

/**
 * �� ���� ����ϴ� ������ ����� ���
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 25. ���� 10:37:39
 * @version 1.0
 */
public class MainThread2 {

	public static void main(String[] args) {
		System.out.println("Start...................");
		
		
		// ���� �ȿ��ٰ� Anonymous interface�� ������ �ϳ� ����
		// Thread1
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
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
		});
		
		
		// Thread2
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				int i = 0;
				while(i <=100) {
					i++;
					// ���������� �ϳ� �޴� �Ͱ���
					System.out.println("MyThread2 "+ i);
					try {
						Thread.sleep(1500);			// �ӵ�����: 1.5��
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}
		});
		
		t1.start();
		t2.start();
		
		
		// �������̽� Ÿ�� ������ ���� ���
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				int i = 0;
				while(i <=100) {
					i++;
					// ���������� �ϳ� �޴� �Ͱ���
					System.out.println("MyThread3 "+ i);
					try {
						Thread.sleep(500);			// �ӵ�����: 0.5��
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}
		};
		// Thread ��ü ����
		// Thread3
		Thread t3 = new Thread(r1);
		t3.start();
		
		
		System.out.println("End...................");
	}

}
