package test;

import dao.BookDao;
import frame.Dao;
import vo.BookVo;

/**
 * delete() Test
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 27. ¿ÀÈÄ 2:39:29
 * @version 1.0
 */
public class DeleteTest {

	public static void main(String[] args) {
		Dao<Integer, BookVo> dao = new BookDao();
		
		try {
			dao.delete(7);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
