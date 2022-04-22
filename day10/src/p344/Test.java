/**
 * 
 */
package p344;

import java.util.ArrayList;

/**
 * Collection API(Application Programming Interface) = Array ��ü
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 20. ���� 1:11:51
 */
public class Test {
	
	public static void main(String[] args) {
		// ���� ��� = �迭 : ����� �׻� �����ؾ� �ϴ� ����
//		CustomerVO cs[] = new CustomerVO[5];
		
		// ArrayList: ������ �ڵ� ����
		ArrayList<CustomerVO> list = new ArrayList<CustomerVO>();	// �޺κ� Ÿ���� optional
		list.add(new CustomerVO("id01","pwd01","james"));
		list.add(new CustomerVO("id02","pwd02","kang"));
		list.add(new CustomerVO("id03","pwd03","kim"));
		
		// ȭ�鿡 �����ֱ� foreach
		for (CustomerVO cus : list) {
			System.out.println(cus);
		}
	}

}
