package cust;

// API Library: java.sql 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC(Java Database Connectivity) Program
 * CRUD ���α׷���: CREATE = INSERT 
 * shopdb�� Cust table�� �����͸� �ִ´�.
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 25. ���� 3:12:35
 * @version 1.0
 */
public class InsertCust {

	public static void main(String[] args) {
		
		// 1. ��������
		Connection con = null;				// DB�� ����, ��� DB�� ���������� ���� �𸥴�
		PreparedStatement ps = null;
		String sql = "INSERT INTO CUST VALUES (?,?,?)";	// SQL������ ��	
														// WORKBENCH������ �޸� ;�� ���� ����
														// ����ǥ�ȿ� �����͸� ������ �ڵ����� ����
		// 2. MySQL JDBC Driver Loading
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	// mySQL�� �����ϰڴ�. (����̹� ��ü�� �ϸ� �ش� DB���Ӱ���-����)
			System.out.println("MySQL JDBC Driver Loading...");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}		
		
		// 3. MySQL Connect
		String url = "jdbc:mysql://192.168.25.45:3306/shopdb?serverTimezone=Asia/Seoul";			
		// protocol//IPv4�ּ�:portNum/Schema����?serverTimezone // root�� ���� �Ұ�		
		//����ǻ�� 127.0.0.1 - root�ε� ���Ӱ���  			
		String mId = "admin1";				// ���Ȼ��� ������ root�� ������ ���� ����
											// root�� ���� �Ǹ��� ���� admin1�� ���� ����.
		String mPwd = "111111";
		try {
			con = DriverManager.getConnection(url,mId,mPwd);		// ������ �õ��Ѵ�. 
			System.out.println("MySQL Server Connected...");
		} catch (SQLException e) {									// -> ������ �׾��ְų� ���Ͱ� �����ְų� ��Ʈ��ũ ���� ���� ���
			
			e.printStackTrace();
		}
		
		// 4. SQL�� �̿��� ��û
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "id05");	//sql���� ?�� ���ֱ�
			ps.setString(2,	"pwd05");
			ps.setString(3,	"�̸���");
			// ��û ����� Ȯ��
			int result = ps.executeUpdate();	// ���� ������
			System.out.println(result);			// result = 1 => �� ���� result �ƴ�
			
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
