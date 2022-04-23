/**
 * 
 */
package p346;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

/**
 * DB대신 HashMap을 이용해 저장공간을 구현
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. 오후 2:30:06
 */
public class OracleDAO implements DAO {

	// 저장공간 탑재.
	HashMap<String, CustomerVO> map;	// 선언만 해서는 사용 못한다.
	
	public OracleDAO() {
		map = new HashMap<String, CustomerVO>();	// 생성
	}
	
	@Override
	public void insert(CustomerVO c) {
		String key = c.getId();			// 받은 고객 정보의 id를 얻는다.
		map.put(key, c);				// 저장공간에 정보를 넣는다.
	}

	@Override
	public void delete(String id) {
		map.remove(id);
	}

	@Override
	public void update(CustomerVO c) {
		String key = c.getId();
		map.put(key, c);
	}
	
	@Override
	public CustomerVO select(String id) {
		CustomerVO c = null;			// 리턴할 객체를 생성한다.
		c = map.get(id);				// 받은 id의 정보를 객체에 넣어 리턴한다.
		return c;
	}

	/**
	 * 저장공간에 있는 모든 정보를 보여준다.
	 */
	@Override
	public ArrayList<CustomerVO> select() {
		ArrayList<CustomerVO> list = new ArrayList<>();	// 리턴할 객체를 생성.
		Collection<CustomerVO> col = map.values();
		Iterator<CustomerVO> it = col.iterator();		
		
		
		while(it.hasNext()) {							// Value가 있을 때까지
			CustomerVO cust = it.next();				// ArrayList에 넣고 리턴.
			list.add(cust);
		}
		return list;
	}

}
