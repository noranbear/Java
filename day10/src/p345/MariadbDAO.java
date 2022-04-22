/**
 * 
 */
package p345;

import java.util.ArrayList;

/**
 * 데이터베이스 MariadbDAO과 연동하는 클래스
 * 내용은 OracleDAO와 같다.
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. 오후 2:42:02
 */
public class MariadbDAO implements DAO {

	@Override
	public void insert(CustomerVO c) {
		connect();
		System.out.println("Mariadb Inserted: " + c);
		close();
	}

	@Override
	public void delete(String id) {
		connect();
		System.out.println("Mariadb Deleted: " + id);
		close();

	}

	@Override
	public CustomerVO select(String id) {
		System.out.println("Mariadb Selected: " + id);
		connect();
		CustomerVO c = new CustomerVO("id01", "pwd01", "james");
		close();
		
		return c;
	}

	@Override
	public ArrayList<CustomerVO> select() {
		System.out.println("Mariadb Selected ALL: ");
		connect();
		ArrayList<CustomerVO> list = new ArrayList<>();
		list.add(new CustomerVO("id01","pwd01","james"));
		list.add(new CustomerVO("id02","pwd02","kang"));
		list.add(new CustomerVO("id03","pwd03","kim"));
		close();
		
		return list;
	}

}
