package p346;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Map study
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. 오후 3:26:22
 */
public class Test {

	public static void main(String[] args) {
		// Map - key, value를 저장하는 공간. 
		// ArrayList key- value, value, value ...
		// Map - (key,value)(key,value)(key,value)
		
		
		// HashMap의 선언
		HashMap<String, CustomerVO> map = new HashMap<String, CustomerVO>();
		
		// 데이터 넣기 - insert
		CustomerVO c1 = new CustomerVO("id01", "pwd01", "bae");
		CustomerVO c2 = new CustomerVO("id02", "pwd02", "kim");
		CustomerVO c3 = new CustomerVO("id03", "pwd03", "kang");
		CustomerVO c4 = new CustomerVO("id04", "pwd04", "park");
		CustomerVO c5 = new CustomerVO("id05", "pwd05", "son");
		
		map.put("id01", c1);
		map.put("id02", c2);
		map.put("id03", c3);
		map.put("id04", c4);
		map.put("id05", c5);
		
		// delete
		map.remove("id02");
		
		// update
		CustomerVO cc = new CustomerVO("id03", "ppp03", "jj03"); // id는 변경 못함.
		map.put("id03", cc);
		
		// select
		String id = "id03";
		CustomerVO c = map.get(id);
		System.out.println(c);
		
		// select all
		Collection<CustomerVO> col = map.values();
		Iterator<CustomerVO> it = col.iterator();
		
		ArrayList<CustomerVO> list = new ArrayList<>();
		while(it.hasNext()) {
			CustomerVO cust = it.next();
			list.add(cust);
		}
		
		for (CustomerVO cu : list) {	// 화면에 보여주기
			System.out.println(cu);
		}	
	}
}
