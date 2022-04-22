/**
 * 
 */
package p345;

import java.util.ArrayList;

/**
 * OracleDAO�� MariadbDAO�� ����� ���ǵǾ� �ִ� �������̽�
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. ���� 2:09:59
 */
public interface DAO {
	
	// �������̽��� ���� Ŭ�������� ���������� ���� �Ϲ� �Լ��� ������ �� �ִ�.
	// default Ű���� ���
	/**
	 * ������ ���� ���� �޼ҵ�
	 */
	public default void connect() {
		System.out.println("Oracle Server Connected.....");
	}
	/**
	 * ������ ���� ���� ���� �޼ҵ�
	 */
	public default void close() {
		System.out.println("Oracle Server Closed........");
	}
	
	// �������̽��� Abstract keyword ���� method header�� �ᵵ �߻�޼ҵ�ȭ��.
	public void insert(CustomerVO c);		
	public void delete(String id);
	public CustomerVO select(String id);
	public ArrayList<CustomerVO> select();
	
}
