package test;

import dao.CustDao;
import frame.Dao;
import vo.CustVo;

/**
 * insertCust() Method Test
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 26. 오후 2:12:46
 * @version 1.0
 */
public class InsertCust {

	public static void main(String[] args) {
		Dao<String, CustVo> dao = new CustDao();
		
		CustVo cust = new CustVo("id100", "pwd77", "이말숙");
		
		try {
			dao.insert(cust);
			System.out.println("Completed 1");
			
			// Duplicated key
			dao.insert(cust);
			System.out.println("Completed 2");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

}
