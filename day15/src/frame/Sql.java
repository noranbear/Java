package frame;

/**
 * Book table�� ���� CRUD Sql������ �����ϰ� ����.
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 27.
 * @version 1.0
 */
public class Sql {
	
	public static String insert = "INSERT INTO BOOK VALUES (NULL,?,?,?,1)";
	public static String delete = "DELETE FROM BOOK WHERE id=?";
	public static String update = "UPDATE BOOK SET status=? WHERE id=?";
	public static String select = "SELECT * FROM BOOK WHERE id=?";
	public static String selectAll = "SELECT * FROM BOOK";
	
}
