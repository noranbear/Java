package test;

import dao.BookDao;
import frame.Dao;
import vo.BookVo;

/**
 * Select Method Test
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 27. ¿ÀÈÄ 2:39:29
 * @version 1.0
 */
public class SelectTest {

	public static void main(String[] args) {
		Dao<Integer, BookVo> dao = new BookDao();
		BookVo book = null;
		
		try {
			book = dao.select(1);
			System.out.println(book);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
