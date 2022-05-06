package frame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * JDBC ���α׷��� ���������� ��Ÿ���� �κ��� ����
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 26. ���� 1:17:10
 * @version 1.0
 */
public abstract class Dao<K,V> {
	String url = "jdbc:mysql://192.168.25.45:3306/librarydb?serverTimezone=Asia/Seoul";			  			
	String id = "admin1";
	String pw = "111111";
	
	
	public Dao() {
		// MySQL JDBC Driver Loading
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	// mySQL�� �����ϰڴ�. (����̹� ��ü�� �ϸ� �ش� DB���Ӱ���-����)
			System.out.println("MySQL JDBC Driver Loading...");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}	
	}
	
	/**
	 * Connects to MySQL
	 */
	public Connection getConnection() throws SQLException {
		Connection con = null;
		
		// ���⼭ try/catch�� ������ ������ ȭ�鿡 �� ������ ������ ����������. (���� ó������ �ʰڴ�)
		con = DriverManager.getConnection(url,id,pw);
		
		return con;
	}
	
	// Close
	public void close(Connection con) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void close(PreparedStatement ps) {
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	public void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
	}
	
	// CRUD
	public abstract void insert(V val) throws Exception;
	public abstract void delete(K key) throws Exception;
	// �뿩
	public abstract void update0(K key) throws Exception;
	// �ݳ�
	public abstract void update1(K key) throws Exception;
	public abstract V select(K key) throws Exception;
	public abstract List<V> select() throws Exception;
	
	

}
