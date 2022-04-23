
package multi;

/**
 * Employee 클래스를 상속하는 비서를 설계
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 18. 오후 4:21:34
 * @version 1.0
 */
public class Secretary extends Employee{
	private String boss;

	// Constructors
	public Secretary() {
	}

	public Secretary(String empNo, String name, double salary, String boss) {
		super(empNo, name, salary);
		this.boss = boss;
	}

	
	@Override
	public double incentive(double inc) {
		return inc * 0.6;
	}
	

	@Override
	public String toString() {
		return "Secretary [boss=" + boss + ", toString()=" + super.toString() + "]";
	}

}
