package p576;

/**
 * ��Ƽ������� ���۽�Ų��
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 25. ���� 9:45:15
 * @version 1.0
 */
public class MainThread {

	public static void main(String[] args) {
		// ���ν�����
		System.out.println("Start...................................");
		MyThread1 t1 = new MyThread1();		// Ŭ���� Thread ���
		// ù��° ���� �ٿ�ε�
		t1.start();
		
		// �ι�° ���� �ٿ�ε�
		MyThread2 t2 = new MyThread2();		//�������̽� Runnable ���
		Thread tt2 = new Thread(t2);
		tt2.start();
		
		// ������� �� ����ǰ� end�� �������� ���ν������ �� �ȿ� �ִ� �����尡 ������ �������� ������ �ʴ´�.
		System.out.println("End...................................");
	}
}
