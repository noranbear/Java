package cust;

// java.sql�� ���� ��
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC(Java Database Connectivity) Program
 * CRUD ���α׷���: UPDATE
 * shopdb�� Cust table�� �����ϴ� �����͸� ������Ʈ�Ѵ�.
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 25. ���� 3:12:35
 * @version 1.0
 */
public class UpdateCust {

	public static void main(String[] args) {
		// JDBC(Java Database Connectivity) Program
		
		// 1. ��������
		Connection con = null;				
		PreparedStatement ps = null;
		String sql = "UPDATE CUST SET pwd=?, name=? WHERE id=?";	// Insert ��� Update
														// ����ǥ�ȿ� �� �ִ��� �ڵ����� ����
		// 2. MySQL JDBC Driver Loading
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			System.out.println("MySQL JDBC Driver Loading...");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}		
		
		// 3. MySQL Connect
		String url = "jdbc:mysql://192.168.25.45:3306/shopdb?serverTimezone=Asia/Seoul";					
		String mId = "admin1";
		String mPwd = "111111";
		try {
			con = DriverManager.getConnection(url,mId,mPwd);		
			System.out.println("MySQL Server Connected...");
		} catch (SQLException e) {									
			
			e.printStackTrace();
		}
		
		// 4. SQL�� �̿��� ��û
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,	"11111");
			ps.setString(2,	"������");
			ps.setString(3, "id11");
			// ��û ����� Ȯ��
			int result = ps.executeUpdate();	
			System.out.println(result);			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		// 5. MySQL Close	
		}finally {		// ������ ���ܵ� �Ȼ��ܵ� ������ �����
			// Close �ݵ��!!!!!
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
		}
		
		
				
	}

}
