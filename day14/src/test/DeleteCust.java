package test;

import dao.CustDao;
import frame.Dao;
import vo.CustVo;

/**
 * deleteCust() Method Test
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 26. ���� 2:31:35
 * @version 1.0
 */
public class DeleteCust {

	public static void main(String[] args) {
		Dao<String, CustVo> dao = new CustDao();
		
		CustVo cust = new CustVo("id001","pw001","�縻��");
		
		try {
			dao.delete("id01");
			System.out.println("Completed 1");
			
			// ���µ� ������ ���� ����
			dao.delete(cust.getId());
			System.out.println("Completed 2");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
