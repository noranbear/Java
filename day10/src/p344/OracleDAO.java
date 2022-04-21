
package p344;

import java.util.ArrayList;

/**
 * �����ͺ��̽� Oracle�� �����ϴ� Ŭ����
 * DB�� ������ �ִ� ����� ����� �ʾұ� ������ �׷��� �������� ��� ȭ�鿡 ���� ������ ���ѵȴ�.
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. ���� 11:11:19
 */
public class OracleDAO {
	
	/**
	 * ������ ���� ���� �޼ҵ�
	 */
	public void connect() {
		System.out.println("Oracle Server Connected.....");
	}
	
	/**
	 * ������ ���� ���� ���� �޼ҵ�
	 */
	public void close() {
		System.out.println("Oracle Server Closed........");
	}
	
	/**
	 * ���� ������ �޾Ƽ� DB�� �ִ´�.
	 * @param c CustomerVO ��ü ��� �� ���� ����(id, pw, name)
	 */
	public void insert(CustomerVO c) {	// connection ���� - �������� - close ���� �ʿ�
		connect();
		// ���������ϴ� �ڵ�� ���� �� ����� ������
		System.out.println(c);
		System.out.println("Inserted.");
		close();
	}
	
	/**
	 * DB�� ���� ���� ���̵� �޾Ƽ� �ش� �������� �����.
	 * @param id ���� id
	 */
	public void delete(String id) {
		connect();
		System.out.println(id);
		System.out.println("Deleted.");
		close();
	}
	
	/**
	 * id�� �ش��ϴ� (����� ������) pw�� name�� ����ҿ��� �����ͼ� CustomerVO��ü�� �ִ´�.
	 * @param id ������� �������� ���̵�
	 * @return ���Ƿ� ���� ������ �� ����
	 */
	public CustomerVO select(String id) {
		connect();
		// ������ ���� ����
		String pwd = "pw01";
		String name = "james";
		CustomerVO c = new CustomerVO(id, pwd, name);	
		close();
		
		return c;
	}
	
	/**
	 * �����ͺ��̽��� �ִ� ��� ������ (����)������ �����ش�.
	 * @return ������ ����Ʈ
	 */
	 public ArrayList<CustomerVO> select(){
		 connect();
		// �������� ������ ������ ���� ���� ���� �� �ִ� ArrayList �����
		ArrayList<CustomerVO> list = new ArrayList<>();
		
		// List �ȿ� DB�� ����Ǿ� �����Ŷ�� �����Ǵ� ������ �������� ����� ����ִ´�.
		list.add(new CustomerVO("id01","pwd01","james"));
		list.add(new CustomerVO("id02","pwd02","kang"));
		list.add(new CustomerVO("id03","pwd03","kim"));
		close();
		
		return list;
	 }
}
