/**
 * 
 */
package ws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import p346.CustomerVO;

/**
 *
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. 오후 4:56:18
 */
public class TodoDAO implements DAO {

	Map<String, TodoVO> map;
	
	public TodoDAO() {
		map = new HashMap<String, TodoVO>();
	}
	
	@Override
	public void insert(TodoVO d) {
		String key = d.getNum();
		map.put(key, d);
	
	}

	/**
	 * done으로 된 리스트를 모두 지운다.(not done)
	 */
	@Override
	public void delete(String num) {
		map.remove(num);
		// 1.??? false를 찾는다
		// 2. key를 뽑아낸다
		// 3. 지운다.
////		for (K key : map.keySet()) {
//            if (value.equals(map.get(key))) {
//                return key;
//            }
//        }
//		
//		
//		
//		
//		map.remove(getkey(map, true););

	}

	@Override
	public void update(TodoVO d) {
		String key = d.getNum();
		map.put(key, d);

	}

	@Override
	public TodoVO select(String id) {
		TodoVO t = null;
		t = map.get(id);
		return t;
	}

	@Override
	public ArrayList<TodoVO> select() {
		Collection<TodoVO> col = map.values();
		Iterator<TodoVO> it = col.iterator();
		
		ArrayList<TodoVO> list = new ArrayList<>();
		while(it.hasNext()) {
			TodoVO cust = it.next();
			list.add(cust);
		}
		return list;
	}

}
