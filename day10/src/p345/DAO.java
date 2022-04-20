/**
 * 
 */
package p345;

import java.util.ArrayList;

/**
 *
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. 오후 2:09:59
 */
public interface DAO {
	
	// 인터페이스는 일반 함수도 정의할 수 있다 - default 키워드 사용
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
	
	public void insert(CustomerVO c);		// 인터페이스에 이렇게 쓰면 자동 추상메소드화
	public void delete(String id);
	public CustomerVO select(String id);
	public ArrayList<CustomerVO> select();
	
}
