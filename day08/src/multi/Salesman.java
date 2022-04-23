
package multi;

/**
 * Employee�� ����ϴ� ��������� ����
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 18. ���� 4:21:41
 * @version 1.0
 */
public class Salesman extends Employee{
	private String region;
	private double goal;
	private	double achievedGoal;
	
	// Constructors
	public Salesman() {
	}

	public Salesman(String empNo, String name, double salary) {
		super(empNo, name, salary);
	}

	public Salesman(String empNo, String name, double salary, String region, 
					double goal, double achievedGoal) {
		super(empNo, name, salary);
		this.region = region;
		this.goal = goal;
		this.achievedGoal = achievedGoal;
	}

	/**
	 * �μ�Ƽ�� ���
	 * �μ�Ƽ���� �ۼ�Ƽ���� ���Ƿ� ����.
	 */
	@Override
	public double incentive(double inc) {
		if(achievedGoal >= (goal * 0.9)) {
			return inc;
		}else if(achievedGoal >= (goal * 0.65)) {
			return inc * 0.8;
		}else if(achievedGoal >= (goal * 0.4)) {
			return inc * 0.5;
		}else{
			return inc * 0.3;
		}
	}

	
	@Override
	public String toString() {
		return "Salesman [region=" + region + ", goal=" + goal + ", "
				+ "achievedGoal=" + achievedGoal + ", \n\ttoString()="
				+ super.toString() + "]";
	}
	
}
