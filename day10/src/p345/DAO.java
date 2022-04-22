/**
 * 
 */
package p345;

import java.util.ArrayList;

/**
 * OracleDAO와 MariadbDAO의 기능이 정의되어 있는 인터페이스
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. 오후 2:09:59
 */
public interface DAO {
	
	// 인터페이스는 하위 클래스에서 공통적으로 쓰일 일반 함수도 정의할 수 있다.
	// default 키워드 사용
	/**
	 * 가상의 서버 접속 메소드
	 */
	public default void connect() {
		System.out.println("Oracle Server Connected.....");
	}
	/**
	 * 가상의 서버 연결 끊기 메소드
	 */
	public default void close() {
		System.out.println("Oracle Server Closed........");
	}
	
	// 인터페이스에 Abstract keyword 없이 method header만 써도 추상메소드화함.
	public void insert(CustomerVO c);		
	public void delete(String id);
	public CustomerVO select(String id);
	public ArrayList<CustomerVO> select();
	
}
