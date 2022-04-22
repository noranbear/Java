/**
 * 
 */
package p345;

import java.util.ArrayList;

/**
 * 데이터베이스 Oracle과 연동하는 클래스
 * DB에 정보를 넣는 방법을 배우지 않았기 때문에 그러한 행위들은 모두 화면에 쓰는 정도로 제한된다.
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. 오후 2:30:06
 */
public class OracleDAO implements DAO {

	@Override
	public void insert(CustomerVO c) {
		connect();
		System.out.println("Oracle Inserted: " + c);
		close();

	}

	@Override
	public void delete(String id) {
		connect();
		System.out.println("Oracle Deleted: " + id);
		close();
	}

	@Override
	public CustomerVO select(String id) {
		System.out.println("Oracle Selected: " + id);
		connect();
		CustomerVO c = new CustomerVO("id01", "pwd01", "james");
		close();
		
		return c;
	}

	@Override
	public ArrayList<CustomerVO> select() {
		System.out.println("Oracle Selected ALL: ");
		connect();
		ArrayList<CustomerVO> list = new ArrayList<>();
		list.add(new CustomerVO("id01","pwd01","james"));
		list.add(new CustomerVO("id02","pwd02","kang"));
		list.add(new CustomerVO("id03","pwd03","kim"));
		close();
		
		return list;
	}

}
