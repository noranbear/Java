package test;

import dao.CustDao;
import frame.Dao;
import vo.CustVo;

/**
 * deleteCust() Method Test
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 26. 오후 2:31:35
 * @version 1.0
 */
public class DeleteCust {

	public static void main(String[] args) {
		Dao<String, CustVo> dao = new CustDao();
		
		CustVo cust = new CustVo("id001","pw001","양말숙");
		
		try {
			dao.delete("id01");
			System.out.println("Completed 1");
			
			// 없는데 에러가 뜨지 않음
			dao.delete(cust.getId());
			System.out.println("Completed 2");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
