package test;

import java.util.ArrayList;
import java.util.List;

import dao.BookDao;
import frame.Dao;
import vo.BookVo;

/**
 * Select All Method Test
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 27. ¿ÀÈÄ 2:39:29
 * @version 1.0
 */
public class SelectAllTest {

	public static void main(String[] args) {
		Dao<Integer, BookVo> dao = new BookDao();
		List<BookVo> list = new ArrayList<BookVo>();
		
		try {
			list = dao.select();
			for (BookVo b : list) {
				System.out.println(b);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
