package ws;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * �� �� ��Ͽ� ���� ������� HashMap�� �����ϴ� Ŭ����
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. ���� 4:56:18
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
	 * ������ ������ ����Ʈ�� �����.
	 * -> ����Ϸ��� ��ϵ��� �� ����� ����� �����ϰ� �ʹ�.
	 */
	@Override
	public void delete(String num) {
		map.remove(num);
	}

	/**
	 * ����Ϸ� ����� '�Ϸ�'�� üũ�Ѵ�.
	 */
	@Override
	public void update(String id) {
		TodoVO t = null;
		t = map.get(id);
		t.setDone(true);
	}
	
	/**
	 * ������ ������ ����� �����ش�.
	 */
	@Override
	public TodoVO select(String id) {
		TodoVO t = null;
		t = map.get(id);
		return t;
	}

	/**
	 * ����Ǿ� �ִ� ��� ����� �����ش�.
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
	 * ������ ������ �Ϸ������� ���� ����Ʈ ����� �����ش�.
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
