/**
 * 
 */
package p346;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;


/**
 *
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
		String key = c.getId();
		map.put(key, c);

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
		CustomerVO c = null;
		c = map.get(id);
		return c;
	}

	@Override
	public ArrayList<CustomerVO> select() {
		Collection<CustomerVO> col = map.values();
		Iterator<CustomerVO> it = col.iterator();
		
		ArrayList<CustomerVO> list = new ArrayList<>();
		while(it.hasNext()) {
			CustomerVO cust = it.next();
			list.add(cust);
		}
		return list;
	}

	

}
