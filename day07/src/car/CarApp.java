/**
 * 
 */
package car;

import java.util.Scanner;

/**
 * Car Application
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 15. 오후 2:46:37
 */
public class CarApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Start...");
		Scanner sc = new Scanner(System.in);
		Car car = null;
		
		while(true) {		
			System.out.println("Input cmd(c,a,g,t,s,q): ");		
			String cmd = sc.next();							
			
			// 메뉴 나가기
			if(cmd.equals("q")) {				
				System.out.println("Bye...");
				break;
			
			// 자동차 생성
			}else if(cmd.equals("c")) {
				System.out.println("Input car name: ");
				String name = sc.next();
				System.out.println("Input fuel size: ");
				double fsize = Double.parseDouble(sc.next());				
				System.out.println("Input fuel efficiency: ");
				double fe = Double.parseDouble(sc.next());
				
				car = new Car(name, fsize, fe);
				System.out.println(car + "\n");
				
			// 기름 넣기	
			}else if(cmd.equals("a")) {
				System.out.println("Input amount of gas..");
				double fs = Double.parseDouble(sc.next());
				car.setCfsize(fs);
				
			// 움직이기	
			}else if(cmd.equals("g")) {
				System.out.println("Input distance: ");
				double distance = Double.parseDouble(sc.next());
				car.go(distance);
			
			// 멈추기	
			}else if(cmd.equals("t")) {
				car.stop();	
				
			// 자동차 상태 조회	
			}else if(cmd.equals("s")) {
				System.out.println(car);
				
			}	
		}
		
		sc.close();
		System.out.println("End...");

	}

}
