package p576;

/**
 * MainThread App에서 멀티로 실행될 첫번쨰 Thread
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 25. 오전 10:03:51
 * @version 1.0
 */
public class MyThread1 extends Thread {

	@Override
	public void run() {
		// 1. 0에서 100을 콘솔에 띄운다.
		int i = 0;
		while(i <=100) {
			i++;
			// 음악파일을 하나 받는 것같은
			System.out.println("MyThread1 "+ i);
			try {
				Thread.sleep(1000);			// 속도제어: 1초
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
	}

}
