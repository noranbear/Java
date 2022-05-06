package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import frame.Dao;
import frame.Sql;
import vo.BookVo;

/**
 * librarydb에서 정보를 사용할 때의 CRUD
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 27. 오후 1:32:33
 * @version 2.0
 */
public class BookDao extends Dao<Integer, BookVo> {

	/**
	 * librarydb에 해당 책정보를 집어넣는다.
	 */
	@Override
	public void insert(BookVo val) throws Exception {
		// 1. Connection
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			
			// 2. SQL 요청
			ps = con.prepareStatement(Sql.insert);
			ps.setString(1,val.getTitle());
			ps.setString(2,val.getAuthor());
			ps.setString(3,val.getIsbn());
			
			ps.executeUpdate();
			
		}catch(Exception e) {
			throw e;
		}finally {
			close(ps);
			close(con);
		}
	}
	/**
	 * librarydb에서 해당 책의 정보를 지운다.
	 */
	@Override
	public void delete(Integer key) throws Exception {
		// 1. Connection
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			
			// 2. SQL 요청
			ps = con.prepareStatement(Sql.delete);
			ps.setInt(1,key);
			
			ps.executeUpdate();
			
		}catch(Exception e) {
			throw e;
		}finally {
			close(ps);
			close(con);
		}
	}
	/**
	 * 대여
	 */
	@Override
	public void update0(Integer key) throws SQLException {
		// 1. Connection
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			
			// 2. SQL 요청
			ps = con.prepareStatement(Sql.update);
			ps.setInt(1,0);
			ps.setInt(2,key);
			
			ps.executeUpdate();
			
		// UI에서 NumberFormatException에 대한 메세지를 따로 주기 위해
		// Exception에서 SQLException으로 바꿈.
		}catch(SQLException e) {
			throw new SQLException("존재하지 않는 책입니다.");
		}finally {
			close(ps);
			close(con);
		}
	}
	/**
	 * 반납
	 */
	@Override
	public void update1(Integer key) throws SQLException {
		// 1. Connection
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			
			// 2. SQL 요청
			ps = con.prepareStatement(Sql.update);
			ps.setInt(1,1);
			ps.setInt(2,key);
			
			ps.executeUpdate();
			
		// UI에서 NumberFormatException에 대한 메세지를 따로 주기 위해
		// Exception에서 SQLException으로 바꿈.
		}catch(SQLException e) {
			throw new SQLException("존재하지 않는 책입니다.");
		}finally {
			close(ps);
			close(con);
		}
	}
	/**
	 * librarydb에 있는 책 중 선택된 책의 정보를 가져온다.
	 */
	@Override
	public BookVo select(Integer key) throws SQLException {
		BookVo b = null;
		// 1. Connection
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			// 2. SQL 요청
			ps = con.prepareStatement(Sql.select);
			ps.setInt(1, key);
			
			rs = ps.executeQuery();
			rs.next();
		
			int id = rs.getInt("id");
			String title = rs.getString("title");
			String author = rs.getString("author");
			String isbn = rs.getString("isbn");
			int status = rs.getInt("status");
			
			b = new BookVo(id,title,author,isbn,status);
		
		// UI에서 NumberFormatException에 대한 메세지를 따로 주기 위해
		// Exception에서 SQLException으로 바꿈.
		}catch(SQLException e){
			throw new SQLException("존재하지 않는 책입니다.");
			
		}finally {
			close(con);
			close(ps);
			close(rs);
		}
		return b;
	}
	/**
	 * libraraydb에 있는 책의 모든 정보를 가져온다.
	 */
	@Override
	public List<BookVo> select() throws Exception {
		List<BookVo> list = new ArrayList<BookVo>();
		// 1. Connection
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			// 2. SQL 요청
			ps = con.prepareStatement(Sql.selectAll);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String title = rs.getString("title");
				String author = rs.getString("author");
				String isbn = rs.getString("isbn");
				int status = rs.getInt("status");
				
				BookVo b = new BookVo(id,title,author,isbn,status);
				list.add(b);
			}
		
		}catch(Exception e) {
			throw new Exception("책 목록을 불러올 수 없습니다.");
		}finally {
			close(con);
			close(ps);
			close(rs);
		}
		return list;
	}

}
