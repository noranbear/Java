
package p344;

import java.util.ArrayList;

/**
 * 데이터베이스 Oracle과 연동하는 클래스
 * DB에 정보를 넣는 방법을 배우지 않았기 때문에 그러한 행위들은 모두 화면에 쓰는 정도로 제한된다.
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
	
	/**
	 * 고객의 정보를 받아서 DB에 넣는다.
	 * @param c CustomerVO 객체 어느 한 고객의 정보(id, pw, name)
	 */
	public void insert(CustomerVO c) {	// connection 과정 - 가져오기 - close 과정 필요
		connect();
		// 정보저장하는 코드는 아직 안 배웠기 때문에
		System.out.println(c);
		System.out.println("Inserted.");
		close();
	}
	
	/**
	 * DB에 있을 고객의 아이디를 받아서 해당 정보들을 지운다.
	 * @param id 고객의 id
	 */
	public void delete(String id) {
		connect();
		System.out.println(id);
		System.out.println("Deleted.");
		close();
	}
	
	/**
	 * id에 해당하는 (현재는 가상의) pw와 name을 저장소에서 가져와서 CustomerVO객체에 넣는다.
	 * @param id 보고싶은 고객정보의 아이디
	 * @return 임의로 만든 가상의 고객 정보
	 */
	public CustomerVO select(String id) {
		connect();
		// 가상의 정보 생성
		String pwd = "pw01";
		String name = "james";
		CustomerVO c = new CustomerVO(id, pwd, name);	
		close();
		
		return c;
	}
	
	/**
	 * 데이터베이스에 있는 모든 고객들의 (가상)정보를 보여준다.
	 * @return 고객정보 리스트
	 */
	 public ArrayList<CustomerVO> select(){
		 connect();
		// 여러가지 정보를 사이즈 제한 없이 담을 수 있는 ArrayList 만들기
		ArrayList<CustomerVO> list = new ArrayList<>();
		
		// List 안에 DB에 저장되어 있을거라고 생각되는 가상의 정보들을 만들어 집어넣는다.
		list.add(new CustomerVO("id01","pwd01","james"));
		list.add(new CustomerVO("id02","pwd02","kang"));
		list.add(new CustomerVO("id03","pwd03","kim"));
		close();
		
		return list;
	 }
}
