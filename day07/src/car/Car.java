/**
 * 
 */
package car;

/**
 * Design Car
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 15. 오후 2:17:05
 */
public class Car {
	private String name;		// no setters
	private double fsize;		// no setters
	private double cfsize;
	private double fe;
	private String status;	// GO, STOP
	
	
	// 언제나 만들어 놓자.
	public Car() {
	}

	public Car(String name, double fsize, double fe) {
		this.name = name;
		this.fsize = fsize;
		this.fe = fe;
		this.status = "STOP";
	}

	// 언제나 만들어 놓자.
	public Car(String name, double fsize, double cfsize, double fe, String status) {
		this.name = name;
		this.fsize = fsize;
		this.cfsize = cfsize;
		this.fe = fe;
		this.status = status;
	}

	// Getters and Setters
	/**
	 * @return the cfsize
	 */
	public double getCfsize() {
		return cfsize;
	}

	/**
	 * @param cfsize the cfsize to set
	 */
	public void setCfsize(double cfsize) {
		this.cfsize = cfsize;
	}

	/**
	 * @return the fe
	 */
	public double getFe() {
		return fe;
	}

	/**
	 * @param fe the fe to set
	 */
	public void setFe(double fe) {
		this.fe = fe;
	}

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
	 * @return the fsize
	 */
	public double getFsize() {
		return fsize;
	}

	public void go(double distance) {
		// 기름이 없으면 못 간다.
		if(this.cfsize == 0) {
			System.out.println("기름이 없습니다.");
			return;
		}
		System.out.println(this.name + ": GO");
		this.status = "GO";
		//*? 음수가 나오면 안 된다.
		this.cfsize -= (distance /this.fe);		// 현재연료량 -= 간 거리/연비
	}
	
	public void stop() {
		System.out.println(this.name + ": STOP");
		this.status = "STOP";
	}
	
	// toString()
	@Override
	public String toString() {
		return "Car [name=" + name + ", fsize=" + fsize + ", cfsize=" + cfsize + ", fe=" + fe + ", status=" + status
				+ "]";
	}
	
	
	
	
	
	
	
}
