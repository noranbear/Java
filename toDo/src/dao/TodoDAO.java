
package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

import frame.DAO;
import frame.Search;
import vo.TodoVO;


/**
 * To do DAO
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 22. ���� 4:41:38
 */
public class TodoDAO implements DAO<String, TodoVO>, Search<TodoVO, Boolean> {

	HashMap<String, TodoVO> map;
	
	// Constructor
	/**
	 * ��������� �����Ѵ�.
	 */
	public TodoDAO() {
		map = new HashMap<String, TodoVO>();
	}
	
	// Methods
	/**
	 * ���� ����� �޾� �����Ѵ�.
	 */
	@Override
	public void insert(TodoVO v) throws Exception {
		String key = v.getNum();
		// �ش� ����Ʈ �ѹ��� �̹� �����ϴ� ���
		if(map.containsKey(key)) {
			throw new Exception("Duplicated list number.");
		}
		map.put(key, v);
		
	}

	/**
	 * ������ ����� �����.
	 */
	@Override
	public void delete(String k) throws Exception {
		// �ش� ����Ʈ �ѹ��� ã�� �� ���� ���
		if(!(map.containsKey(k))) {
			throw new Exception("Can't find the list.");
		}
		map.remove(k);
		
	}

	/**
	 * To do list���� �޼��� ����� ��� �����.
	 * ?? �ϳ��� �������� null�� ������ ����
	 */
	@Override
	public void delete() throws Exception {
		// ��ϵǾ� �ִ� ����Ʈ�� ���� ���
		if(map.isEmpty() == true) {
			throw new Exception("There's nothing to do.");
		}
		ArrayList<TodoVO> list = new ArrayList<TodoVO>();
		Collection<TodoVO> col = map.values();
		Iterator<TodoVO> it = col.iterator();

		while(it.hasNext()) {
			TodoVO cust = it.next();
			if(cust.isDone()) {
				list.add(cust);
				map.remove(cust.getNum());
			}
		}
		// ������ �޼��� ��ǥ�� ���� ���
		if(list.isEmpty()) {
			throw new Exception("There's no completed lists.");
		}
		
		System.out.println("Removed all the completed lists.");
	}

	/**
	 * to do list�� �� ����� ��� üũ�Ѵ�.
	 */
	@Override
	public void update(String k) throws Exception {
		TodoVO t = null;
		if(map.containsKey(k) == false) {
			throw new Exception("Can't find the value.");
		}
		t = map.get(k);
		// if it's already true?
		if(t.isDone() == true) {
			throw new Exception("It's already done.");
		}
		t.setDone(true);
		
	}

	@Override
	public TodoVO select(String k) throws Exception {
		TodoVO t = null;
		if(map.containsKey(k) == false) {
			throw new Exception("Can't find the value.");
		}
		t = map.get(k);
		return t;
	}

	@Override
	public ArrayList<TodoVO> select() throws Exception {
		// ��ϵǾ� �ִ� ����Ʈ�� ���� ���
		if(map.isEmpty()) {
			throw new Exception("There's nothing to do.");
		}
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
	 * ���õ� �Ϸ� ������ ���� ����Ʈ�� �����ش�.
	 */
	@Override
	public ArrayList<TodoVO> search(Boolean done) throws Exception {
		// ��ϵǾ� �ִ� ����Ʈ�� ���� ���
		if(map.isEmpty()) {
			throw new Exception("There's no lists.");
		}
		
		// 1. ������ ArrayList�� �����.
		ArrayList<TodoVO> list = new ArrayList<TodoVO>();
		
		Collection<TodoVO> col = map.values();
		Iterator<TodoVO> it = col.iterator();

		// 2. Map���� �ش� ������ Value�� ã�� ArrayList�� �ִ´�.
		while(it.hasNext()) {
			TodoVO cust = it.next();
			if(cust.isDone() == done) {
				list.add(cust);
			}
		}
		// ã�� list�� ���� ���
		if(list.isEmpty()) {
			// �Ϸ�� ����Ʈ�� ã�� ���
			if(done == true) {
				throw new Exception("There's no completed lists.\n");
			// �Ϸ���� ���� ����Ʈ�� ã�� ���
			}else {
				throw new Exception("There's uncompleted lists.\n");
			}
			
		}
		return list;
	}

}
