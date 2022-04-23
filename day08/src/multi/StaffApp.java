
package multi;

/**
 * Employee class���� �׽�Ʈ�غ� �� �ִ� app
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 18. ���� 4:22:11
 * @version 1.0
 */
public class StaffApp {

	public static void main(String[] args) {
		// 1. ��� �� ��ü�� �����ϰ� ����Ͻÿ�.
		Employee ee[] = new Employee[4];
		ee[0] = new Employee("1111", "Kim", 300);
		ee[1] = new Secretary("2222", "Son", 350, "Boss");
		ee[2] = new Salesman("3333", "Park", 300, "NYC", 400, 200);
		ee[3] = new Manager("4444", "Kang", 500, 200);
		
		for (int i = 0; i < ee.length; i++) {
			System.out.println(ee[i].toString());
		}
				
		// 2. ��� ����� ���� ������ ����Ͻÿ�.
		System.out.println("\n[Annual salary]");
		for (int i = 0; i < ee.length; i++) {
			System.out.println(ee[i].getClass().getSimpleName() + ": "
								+ ee[i].annSalary());
		}
		
		// 3. ��� ������� �μ�Ƽ�긦 ����ؼ� �������.
		System.out.println("\n[Incentive]");
		double incentive = 200;
		for (int i = 0; i < ee.length; i++) {
			double earnedInc = 0.0;
			earnedInc = ee[i].incentive(incentive);
			System.out.println(ee[i].getClass().getSimpleName() + ": " + earnedInc);
		}			

	}

}
