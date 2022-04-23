
package multi;

/**
 * Employee Ŭ������ ����ϴ� �Ŵ����� ����
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 18. ���� 4:21:49
 * @version 1.0
 */
public class Manager extends Employee{
	// �Ŵ����� bonus�� ������ �ִ�
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
