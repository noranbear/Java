package p576;

/**
 * 더 많이 사용하는 스레드 만드는 방법
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 25. 오전 10:37:39
 * @version 1.0
 */
public class MainThread2 {

	public static void main(String[] args) {
		System.out.println("Start...................");
		
		
		// 메인 안에다가 Anonymous interface로 스레드 하나 만듬
		// Thread1
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
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
		});
		
		
		// Thread2
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				int i = 0;
				while(i <=100) {
					i++;
					// 음악파일을 하나 받는 것같은
					System.out.println("MyThread2 "+ i);
					try {
						Thread.sleep(1500);			// 속도제어: 1.5초
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}
		});
		
		t1.start();
		t2.start();
		
		
		// 인터페이스 타입 스레드 생성 방식
		Runnable r1 = new Runnable() {
			
			@Override
			public void run() {
				int i = 0;
				while(i <=100) {
					i++;
					// 음악파일을 하나 받는 것같은
					System.out.println("MyThread3 "+ i);
					try {
						Thread.sleep(500);			// 속도제어: 0.5초
					} catch (InterruptedException e) {
						e.printStackTrace();
					}		
				}
			}
		};
		// Thread 객체 생성
		// Thread3
		Thread t3 = new Thread(r1);
		t3.start();
		
		
		System.out.println("End...................");
	}

}
