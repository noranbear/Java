package p576;

/**
 * 멀티스레드로 동작시킨다
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 25. 오전 9:45:15
 * @version 1.0
 */
public class MainThread {

	public static void main(String[] args) {
		// 메인스레드
		System.out.println("Start...................................");
		MyThread1 t1 = new MyThread1();		// 클래스 Thread 상속
		// 첫번째 파일 다운로드
		t1.start();
		
		// 두번째 파일 다운로드
		MyThread2 t2 = new MyThread2();		//인터페이스 Runnable 상속
		Thread tt2 = new Thread(t2);
		tt2.start();
		
		// 스레드는 다 실행되고 end가 찍히지만 메인스레드는 그 안에 있는 스레드가 끝나기 전까지는 끝나지 않는다.
		System.out.println("End...................................");
	}
}
