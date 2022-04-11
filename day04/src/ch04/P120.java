package ch04;
/**
 * Workshop using for loop
 * @author Sohee Kim
 * @date 2022-04-11
 */
public class P120 {

	public static void main(String[] args) {
		// 1~10까지의 합을 구하시오
		int sum = 0;
		int count = 0;
		for(int i = 1; i < 11; i++) {
			sum += i;
			count++;
		}
		System.out.println(sum);
		System.out.println(count);	// 10
		System.out.println(sum/count);	// 평균
		
		System.out.println("----------------------------------");
		
		// while loop로
		int s = 1;
		int sum2 = 0;
		
		while(s < 11) {
			sum2 += s;
			s++;
		}
		System.out.println(sum2);
		
		// 1~ 10까지의 합의 평균을 구하시오.
		System.out.println(sum2/s);
		System.out.println(s);	// result: 11, while에서 s가 10일때, 작동 후 s++를 해주었기 때문.
		System.out.println(sum2/(s-1)); // SO, s-1을 해야 s가 10이 된다. (double이 아니기 때문에 정확한 값은 안 나옴)
	}

}
