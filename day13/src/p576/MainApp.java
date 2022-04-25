package p576;

/**
 * 프로그램 안에 main이라는 프로세스 실행되고 끝난다.
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 25. 오전 9:38:21
 * @version 1.0
 */
public class MainApp {

	public static void main(String[] args) {
		System.out.println("Start");
		// 1. 0에서 300까지 화면에 띄워라.
		int i = 0;
		while(i <= 300) {
			System.out.println(i);
			i++;
			
			try {
				Thread.sleep(1000);			 // 스레드가 실행될 때, 1초 후에 실행하라. (1초 동안 쉬어라)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("End");
	}

}
