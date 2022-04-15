/**
 * 
 */
package ch06;

/**
 * �ڵ��� ��ü�� �����ϱ� ���� Ʋ
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 15. ���� 10:15:38
 */
public class Car {
	// Attribute
	String name;
	String color;
	int size;		// ��ⷮ
	int fsize;		// �⸧�� ������
	int cfsize;		// ���� �⸧��
	
	// Constructor (������) - �ݵ�� Class�� �̸��� ����.
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
	
	// �ڵ����� ���� print
	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", size=" + size + ", fsize=" + fsize + ", cfsize=" + cfsize
				+ "]"; // this.name, this.color and so on. 
	}
	
}
