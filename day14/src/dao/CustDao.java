package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import frame.Dao;
import frame.Sql;
import vo.CustVo;

/**
 * Customer info CRUD System ����
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 26. ���� 1:43:27
 * @version 1.0
 */
public class CustDao extends Dao<String, CustVo> {

	@Override
	public void insert(CustVo val) throws Exception {		
		// 1. Connection
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			
			// 2. SQL�� �̿��� ��û
			// ����
			ps = con.prepareStatement(Sql.insertCust);
			ps.setString(1, val.getId());
			ps.setString(2, val.getPwd());
			ps.setString(3, val.getName());
			//��û
			ps.executeUpdate();
			
		}catch(Exception e) {
			throw e;// �Ͼ ���ܸ� ������-> �޼ҵ� ������ throws�� ���� ȭ������ ���󰣴�.
		}finally {		// exception�� close ���� ���� close�� �ȵǱ� ������ finally�� ����.
			// 3. MySQL Close
			close(ps);
			close(con);
		}
	}

	@Override
	public void delete(String key) throws Exception {
		// 1. Connection
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			
			// 2. SQL ��û
			ps = con.prepareStatement(Sql.deleteCust);
			ps.setString(1, key);
			ps.executeUpdate();
			
		}catch(Exception e) {
			throw e;
		}finally {
			// 3. Close
			close(con);
			close(ps);
		}
	}

	@Override
	public void update(CustVo val) throws Exception {
		// 1. Connection
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConnection();
			
			// 2. SQL ��û
			ps = con.prepareStatement(Sql.updateCust);
			ps.setString(1, val.getPwd());
			ps.setString(2, val.getName());
			ps.setString(3, val.getId());
			ps.executeUpdate();
		}catch(Exception e){
			throw e;
		}finally {
			close(con);
			close(ps);
		}
	}

	@Override
	public CustVo select(String key) throws Exception {
		// 1. Connection
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		CustVo c = null;
		
		try {
			con = getConnection();
			
			// 2. SQL ��û
			ps = con.prepareStatement(Sql.selectCust);
			ps.setString(1, key);
			rs = ps.executeQuery();
			rs.next();
			
			String id = rs.getString("id");
			String pwd = rs.getString("pwd");
			String name = rs.getString("name");
			c = new CustVo(id,pwd,name);
			
		}catch(Exception e) {
			throw e;
		}finally {
			close(con);
			close(ps);
			close(rs);
		}
		
		return c;
	}

	@Override
	public List<CustVo> select() throws Exception {
		// 1. Connection
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<CustVo> list = new ArrayList<CustVo>();
		
		try {
			con = getConnection();
			
			// 2. SQL ��û
			ps = con.prepareStatement(Sql.selectAllCust);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				CustVo c = new CustVo(id,pwd,name);
				list.add(c);
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
