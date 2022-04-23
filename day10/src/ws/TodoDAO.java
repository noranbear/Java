package ws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 할 일 목록에 대한 저장공간 HashMap을 관리하는 클래스
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. 오후 4:56:18
 */
public class TodoDAO implements DAO, Search {

	Map<String, TodoVO> map;
	
	// Constructor
	public TodoDAO() {
		map = new HashMap<String, TodoVO>();
	}
	
	@Override
	public void insert(TodoVO d) {
		String key = d.getNum();
		map.put(key, d);
	}

	/**
	 * 유저가 선택한 리스트를 지운다.
	 * -> 실행완료한 목록들을 다 지우는 기능을 구현하고 싶다.
	 */
	@Override
	public void delete(String num) {
		map.remove(num);
	}

	/**
	 * 실행완료 목록을 '완료'로 체크한다.
	 */
	@Override
	public void update(String id) {
		TodoVO t = null;
		t = map.get(id);
		t.setDone(true);
	}
	
	/**
	 * 유저가 선택한 목록을 보여준다.
	 */
	@Override
	public TodoVO select(String id) {
		TodoVO t = null;
		t = map.get(id);
		return t;
	}

	/**
	 * 저장되어 있는 모든 목록을 보여준다.
	 */
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

	/**
	 * 유저가 선택한 완료유무에 따른 리스트 목록을 보여준다.
	 */
	@Override
	public ArrayList<TodoVO> search(boolean done) {
		ArrayList<TodoVO> list = new ArrayList<TodoVO>();
		
		Collection<TodoVO> col = map.values();
		Iterator<TodoVO> it = col.iterator();

		while(it.hasNext()) {
			TodoVO cust = it.next();
			if(cust.isDone() == done) {
				list.add(cust);
			}
		}
		return list;
	}
}
