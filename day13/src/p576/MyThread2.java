package p576;

/**
 * MainThread App에서 멀티로 실행될 두번째 Thread
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 25. 오전 10:04:15
 * @version 1.0
 */
public class MyThread2 implements Runnable{

	@Override
	public void run() {
		int i = 0;
		while(i <=100) {
			i++;
			// 음악파일을 하나 받는 것같은
			System.out.println("MyThread2 "+ i);
			try {
				Thread.sleep(1500);			// 속도제어: 1.5초 - 네트워크가 느려서라고 정의
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
	}

}
