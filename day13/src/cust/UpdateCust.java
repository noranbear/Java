package cust;

// java.sql만 쓰는 중
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC(Java Database Connectivity) Program
 * CRUD 프로그래밍: UPDATE
 * shopdb의 Cust table에 존재하는 데이터를 업데이트한다.
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 25. 오후 3:12:35
 * @version 1.0
 */
public class UpdateCust {

	public static void main(String[] args) {
		// JDBC(Java Database Connectivity) Program
		
		// 1. 변수선언
		Connection con = null;				
		PreparedStatement ps = null;
		String sql = "UPDATE CUST SET pwd=?, name=? WHERE id=?";	// Insert 대신 Update
														// 물음표안에 뭘 넣던지 자동으로 전송
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
		
		// 4. SQL을 이용한 요청
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1,	"11111");
			ps.setString(2,	"정말숙");
			ps.setString(3, "id11");
			// 요청 결과를 확인
			int result = ps.executeUpdate();	
			System.out.println(result);			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		// 5. MySQL Close	
		}finally {		// 문제가 생겨도 안생겨도 무조건 실행됨
			// Close 반드시!!!!!
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
