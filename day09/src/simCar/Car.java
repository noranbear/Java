
package simCar;

/**
 * Car abstract class
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 19. ¿ÀÈÄ 3:45:33
 * @version 1.0
 */
public abstract class Car {
	private String name;
	private String color;
	private String kind;
	private String serial;
//	private int maxPeople;
//	private int power;
//	private int made;
//	private int year;
	private String status;
	
	// Constructors
	public Car() {
		
	}

	public Car(String name, String color, String kind, String serial) {
		this.name = name;
		this.color = color;
		this.kind = kind;
		this.serial = serial;
		this.status = "PARK";
	}
	
	
	// Methods
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @return the kind
	 */
	public String getKind() {
		return kind;
	}

	/**
	 * @return the serial
	 */
	public String getSerial() {
		return serial;
	}
	
	
	public abstract void go(int distance);
	public abstract void back(int distance);

	
	public void stop() {
		setStatus("STOP");
	}
	
	public void park() {
		setStatus("PARK");
	}
	

	@Override
	public String toString() {
		return "Car [name=" + name + ", color=" + color + ", kind=" + kind + ", "
				+ "serial=" + serial + ", " + ", status=" + status + "]";
	}
	

	
}
