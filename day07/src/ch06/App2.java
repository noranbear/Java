/**
 * 
 */
package ch06;

/**
 *
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 15. ¿ÀÀü 11:23:05
 */
public class App2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Car c1 = new Car();
		System.out.println(c1.toString());

		Car c2 = new Car("K1","red",1000,50,0);
		System.out.println(c2.toString());
		
	}

}
