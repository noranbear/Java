package cust;

// java.sql만 쓰는 중
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBC(Java Database Connectivity) Program
 * CRUD 프로그래밍: DELETE 
 * shopdb의 Cust table에 존재하는 데이터를 지운다.
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 25. 오후 3:12:35
 * @version 1.0
 */
public class DeleteCust {

	public static void main(String[] args) {
		// JDBC(Java Database Connectivity) Program
		
		// 1. 변수선언
		Connection con = null;				// DB와 접속, 어느 DB와 접속할지는 아직 모른다
		PreparedStatement ps = null;
		String sql = "DELETE FROM CUST WHERE id=?";	// SQL문장이 들어감	// WORKBENCH에서와 달리 ;을 찍지 않음
														// 물음표안에 뭘 넣던지 자동으로 전송
		// 2. MySQL JDBC Driver Loading
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	// mySQL에 접속하겠다. (드라이버 교체만 하면 해당 DB접속가능-유연)
			System.out.println("MySQL JDBC Driver Loading...");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}		
		
		// 3. MySQL Connect
		String url = "jdbc:mysql://192.168.25.45:3306/shopdb?serverTimezone=Asia/Seoul";			
		// protocol//IPv4주소:portNum/Schema정보?serverTimezone // root로 접속 불가		
		//내컴퓨터 127.0.0.1 - root로도 접속가능  			
		String mId = "admin1";
		String mPwd = "111111";
		try {
			con = DriverManager.getConnection(url,mId,mPwd);		// 접속을 시도한다. 
			System.out.println("MySQL Server Connected...");
		} catch (SQLException e) {									// -> 서버가 죽어있거나 컴터가 꺼져있거나 네트워크 연결 문제 등등
			
			e.printStackTrace();
		}
		
		// 4. SQL을 이용한 요청
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, "id05");	//sql의 ?에 값넣기
			// 요청 결과를 확인
			int result = ps.executeUpdate();	// 정보 보내기
			System.out.println(result);			// result = 1 => 한 건이 result 됐다
			
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
