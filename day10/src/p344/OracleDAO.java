/**
 * 
 */
package p344;

import java.util.ArrayList;

/**
 * 데이터베이스 Oracle과 연동하는 클래스
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. 오전 11:11:19
 */
public class OracleDAO {
	
	/**
	 * 가상의 서버 접속 메소드
	 */
	public void connect() {
		System.out.println("Oracle Server Connected.....");
	}
	
	/**
	 * 가상의 서버 연결 끊기 메소드
	 */
	public void close() {
		System.out.println("Oracle Server Closed........");
	}
	
	public void insert(CustomerVO c) {	// connection 과정 - 가져오기 - close 과정 필요
		connect();
		// 정보저장하는 코드는 아직 안 배웠기 때문에
		System.out.println(c);
		System.out.println("Inserted.");
		close();
	}
	
	public void delete(String id) {
		connect();
		System.out.println(id);
		System.out.println("Deleted.");
		close();
	}
	
	/**
	 * id에 해당하는 (현재는 가상의) pw와 name을 저장소에서 가져와서 CustomerVO에 넣는다.
	 * @param id
	 * @return
	 */
	public CustomerVO select(String id) {
		connect();
		String pwd = "pw01";
		String name = "james";
		CustomerVO c = new CustomerVO(id, pwd, name);
		close();
		
		return c;
	}
	
	/**
	 * 데이터베이스에 있는 모든 정보를 담아서 던져라
	 * @return
	 */
	 public ArrayList<CustomerVO> select(){
		 connect();
		// 가상으로 가져옴
		ArrayList<CustomerVO> list = new ArrayList<>();
		list.add(new CustomerVO("id01","pwd01","james"));
		list.add(new CustomerVO("id02","pwd02","kang"));
		list.add(new CustomerVO("id03","pwd03","kim"));
		close();
		
		return list;
	 }
}
