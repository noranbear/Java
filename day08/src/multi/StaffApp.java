
package multi;

/**
 * Employee class들을 테스트해볼 수 있는 app
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 18. 오후 4:22:11
 * @version 1.0
 */
public class StaffApp {

	public static void main(String[] args) {
		// 1. 사원 별 객체를 생성하고 출력하시오.
		Employee ee[] = new Employee[4];
		ee[0] = new Employee("1111", "Kim", 300);
		ee[1] = new Secretary("2222", "Son", 350, "Boss");
		ee[2] = new Salesman("3333", "Park", 300, "NYC", 400, 200);
		ee[3] = new Manager("4444", "Kang", 500, 200);
		
		for (int i = 0; i < ee.length; i++) {
			System.out.println(ee[i].toString());
		}
				
		// 2. 모든 사원의 연봉 정보를 출력하시오.
		System.out.println("\n[Annual salary]");
		for (int i = 0; i < ee.length; i++) {
			System.out.println(ee[i].getClass().getSimpleName() + ": "
								+ ee[i].annSalary());
		}
		
		// 3. 모든 사원들의 인센티브를 계산해서 출력하자.
		System.out.println("\n[Incentive]");
		double incentive = 200;
		for (int i = 0; i < ee.length; i++) {
			double earnedInc = 0.0;
			earnedInc = ee[i].incentive(incentive);
			System.out.println(ee[i].getClass().getSimpleName() + ": " + earnedInc);
		}			

	}

}
