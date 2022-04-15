/**
 * 
 */
package ch06;

/**
 * Car를 만드는 application
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 15. 오전 10:26:05
 */
public class App {
	public static void main(String[] args) {
		
		Car c1 = new Car();				// Reference type
//		System.out.println(c1.toString());
//		System.out.println(c1);			// 자동으로 toString이 나오게 설정해둠.
		String result = c1.toString();
		System.out.println(result);
		
		Car c2 = new Car();
		System.out.println(c2);
	}
}
