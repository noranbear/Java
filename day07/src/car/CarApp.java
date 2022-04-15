/**
 * 
 */
package car;

import java.util.Scanner;

/**
 * Car Application
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 15. ���� 2:46:37
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
			
			// �޴� ������
			if(cmd.equals("q")) {				
				System.out.println("Bye...");
				break;
			
			// �ڵ��� ����
			}else if(cmd.equals("c")) {
				System.out.println("Input car name: ");
				String name = sc.next();
				System.out.println("Input fuel size: ");
				double fsize = Double.parseDouble(sc.next());				
				System.out.println("Input fuel efficiency: ");
				double fe = Double.parseDouble(sc.next());
				
				car = new Car(name, fsize, fe);
				System.out.println(car + "\n");
				
			// �⸧ �ֱ�	
			}else if(cmd.equals("a")) {
				System.out.println("Input amount of gas..");
				double fs = Double.parseDouble(sc.next());
				car.setCfsize(fs);
				
			// �����̱�	
			}else if(cmd.equals("g")) {
				System.out.println("Input distance: ");
				double distance = Double.parseDouble(sc.next());
				car.go(distance);
			
			// ���߱�	
			}else if(cmd.equals("t")) {
				car.stop();	
				
			// �ڵ��� ���� ��ȸ	
			}else if(cmd.equals("s")) {
				System.out.println(car);
				
			}	
		}
		
		sc.close();
		System.out.println("End...");

	}

}
