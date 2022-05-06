package test;

import dao.BookDao;
import frame.Dao;
import vo.BookVo;

/**
 * Insert() Test
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 27. 오후 2:39:29
 * @version 1.0
 */
public class InsertTest {

	public static void main(String[] args) {
		Dao<Integer, BookVo> dao = new BookDao();
		BookVo book = new BookVo("비블리아 고서당 사건수첩","미카미 엔","9788926793633");
		
		try {
			dao.insert(book);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
