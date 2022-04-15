/**
 * 
 */
package ch06;

/**
 * 자동차 객체를 생성하기 위한 틀
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 15. 오전 10:15:38
 */
public class Car {
	// Attribute
	String name;
	String color;
	int size;		// 배기량
	int fsize;		// 기름통 사이즈
	int cfsize;		// 현재 기름량
	
	// Constructor (생성자) - 반드시 Class의 이름과 동일.
	public Car() {
	}
	
	public Car(String name, String color, int size, int fsize, int cfsize) {
		this.name = name;
		this.color = color;
		this.size = size;
		this.fsize = fsize;
		this.cfsize = cfsize;
	}


	// Operation -> function
	public void go() {
		System.out.println("Go !");
	}
	

	public void stop() {
		System.out.println("Stop !");
	}
	
	public void addFuels(int f) {
		cfsize += f;
	}
	
	// 자동차의 정보 print
	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", size=" + size + ", fsize=" + fsize + ", cfsize=" + cfsize
				+ "]"; // this.name, this.color and so on. 
	}
	
}
