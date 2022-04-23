
package multi;

/**
 * Employee들이 공통적으로 가지고 있는 특성과 기능을 정의
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 18. 오후 4:21:25
 * @version 1.0
 */
public class Employee {
	private String EmpNo;
	private String name;
	private double salary;
	
	// Constructors
	public Employee() {
	}
	
	public Employee(String empNo, String name, double salary) {
		EmpNo = empNo;
		this.name = name;
		this.salary = salary;
	}

	
	public double annSalary() {
		return this.salary * 12;
	}
	
	/**
	 * 50% 지급
	 * @param inc
	 * @return
	 */
	public double incentive(double inc) {
		return inc * 0.5;
	}
	
	
	@Override
	public String toString() {
		return "Employee [EmpNo=" + EmpNo + ", name=" + name + ", salary=" + salary + "]";
	}
	
}
