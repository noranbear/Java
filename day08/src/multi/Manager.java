
package multi;

/**
 * Employee 클래스를 상속하는 매니저를 설계
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 18. 오후 4:21:49
 * @version 1.0
 */
public class Manager extends Employee{
	// 매니저는 bonus를 가지고 있다
	private double bonus;

	// Constructors
	public Manager() {
	}

	public Manager(String empNo, String name, double salary, double bonus) {
		super(empNo, name, salary);
		this.bonus = bonus;
	}

	
	@Override
	public double annSalary() {
		return super.annSalary() + bonus;
	}

	@Override
	public double incentive(double inc) {
		return inc;
	}

	
	@Override
	public String toString() {
		return "Manager [bonus=" + bonus + ", toString()=" + super.toString() + "]";
	}
	
	
}
