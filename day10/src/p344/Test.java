/**
 * 
 */
package p344;

import java.util.ArrayList;

/**
 * Collection API(Application Programming Interface) = Array 대체
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. 오후 1:11:51
 */
public class Test {
	
	public static void main(String[] args) {
		// 예전 방식 = 배열 : 사이즈를 항상 지정해야 하는 문제
//		CustomerVO cs[] = new CustomerVO[5];
		
		// ArrayList: 사이즈 자동 조절
		ArrayList<CustomerVO> list = new ArrayList<CustomerVO>();	// 뒷부분 타입은 optional
		list.add(new CustomerVO("id01","pwd01","james"));
		list.add(new CustomerVO("id02","pwd02","kang"));
		list.add(new CustomerVO("id03","pwd03","kim"));
		
		// 화면에 보여주기 foreach
		for (CustomerVO cus : list) {
			System.out.println(cus);
		}
	}

}
