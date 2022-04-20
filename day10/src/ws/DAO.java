/**
 * 
 */
package ws;

import java.util.ArrayList;

/**
 *
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. 오후 2:09:59
 */
public interface DAO {
	
	/**
	 * 가상의 서버 접속 메소드
	 */
	public default void connect() {
		System.out.println("To do list db Connected.....");
	}
	/**
	 * 가상의 서버 연결 끊기 메소드
	 */
	public default void close() {
		System.out.println("To do list db Closed........");
	}
	
	public void insert(TodoVO c);		
	public void delete(String id);
	public void update(TodoVO c);
	public TodoVO select(String id);
	public ArrayList<TodoVO> select();
	
}
