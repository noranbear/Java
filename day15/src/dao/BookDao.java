package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import frame.Dao;
import frame.Sql;
import vo.BookVo;

/**
 * 
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 27. 오후 1:32:33
 * @version 1.0
 */
public class BookDao extends Dao<Integer, BookVo> {

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
	public void update0(Integer key) throws Exception {
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
			
		}catch(Exception e) {
			throw e;
		}finally {
			close(ps);
			close(con);
		}
	}

	/**
	 * 반납
	 */
	@Override
	public void update1(Integer key) throws Exception {
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
			
		}catch(Exception e) {
			throw e;
		}finally {
			close(ps);
			close(con);
		}
	}
	
	@Override
	public BookVo select(Integer key) throws Exception {
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
		
		}catch(Exception e) {
			throw e;
		}finally {
			close(con);
			close(ps);
			close(rs);
		}
		return b;
	}

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
			throw e;
		}finally {
			close(con);
			close(ps);
			close(rs);
		}
		return list;
	}

}
