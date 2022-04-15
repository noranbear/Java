/**
 * 
 */
package ch06;

/**
 * Car Application - 객체 생성 연습
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 15. 오전 11:23:05
 */
public class App2 {

	public static void main(String[] args) {
		// 자동차 객체 생성
		Car c1 = new Car();
		System.out.println(c1.toString());

		Car c2 = new Car("K1","red",1000,50,0);
		System.out.println(c2.toString());
		
	}

}
