/**
 * 
 */
package p345;

import java.util.ArrayList;


/**
 *
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. ¿ÀÈÄ 2:30:06
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
