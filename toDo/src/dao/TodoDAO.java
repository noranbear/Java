
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
 * @since 2022. 4. 22. 오후 4:41:38
 */
public class TodoDAO implements DAO<String, TodoVO>, Search<TodoVO, Boolean> {

	HashMap<String, TodoVO> map;
	
	// Constructor
	/**
	 * 저장공간을 생성한다.
	 */
	public TodoDAO() {
		map = new HashMap<String, TodoVO>();
	}
	
	// Methods
	/**
	 * 할일 목록을 받아 저장한다.
	 */
	@Override
	public void insert(TodoVO v) throws Exception {
		String key = v.getNum();
		// 해당 리스트 넘버가 이미 존재하는 경우
		if(map.containsKey(key)) {
			throw new Exception("Duplicated list number.");
		}
		map.put(key, v);
		
	}

	/**
	 * 선택한 목록을 지운다.
	 */
	@Override
	public void delete(String k) throws Exception {
		// 해당 리스트 넘버를 찾을 수 없는 경우
		if(!(map.containsKey(k))) {
			throw new Exception("Can't find the list.");
		}
		map.remove(k);
		
	}

	/**
	 * To do list에서 달성된 목록을 모두 지운다.
	 * ?? 하나만 지워지고 null이 나오는 문제
	 */
	@Override
	public void delete() throws Exception {
		// 등록되어 있는 리스트가 없는 경우
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
		// 지워질 달성된 목표가 없는 경우
		if(list.isEmpty()) {
			throw new Exception("There's no completed lists.");
		}
		
		System.out.println("Removed all the completed lists.");
	}

	/**
	 * to do list에 한 목록을 골라서 체크한다.
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
		// 등록되어 있는 리스트가 없는 경우
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
	 * 선택된 완료 유무에 따라서 리스트를 보여준다.
	 */
	@Override
	public ArrayList<TodoVO> search(Boolean done) throws Exception {
		// 등록되어 있는 리스트가 없는 경우
		if(map.isEmpty()) {
			throw new Exception("There's no lists.");
		}
		
		// 1. 리턴할 ArrayList를 만든다.
		ArrayList<TodoVO> list = new ArrayList<TodoVO>();
		
		Collection<TodoVO> col = map.values();
		Iterator<TodoVO> it = col.iterator();

		// 2. Map에서 해당 조건의 Value를 찾아 ArrayList에 넣는다.
		while(it.hasNext()) {
			TodoVO cust = it.next();
			if(cust.isDone() == done) {
				list.add(cust);
			}
		}
		// 찾는 list가 없을 경우
		if(list.isEmpty()) {
			// 완료된 리스트를 찾는 경우
			if(done == true) {
				throw new Exception("There's no completed lists.\n");
			// 완료되지 않은 리스트를 찾는 경우
			}else {
				throw new Exception("There's uncompleted lists.\n");
			}
			
		}
		return list;
	}

}
