package test;

import dao.CustDao;
import frame.Dao;
import vo.CustVo;

/**
 * SelectCust() Method Test
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 26. ¿ÀÈÄ 10:30:20
 * @version 1.0
 */
public class SelectCustTest {

	public static void main(String[] args) {
		Dao<String,CustVo> dao = new CustDao();
		CustVo v = null;
		
		try {
			v = dao.select("id100");
			System.out.println(v);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
