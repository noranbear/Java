package ch03;
/**
 * infinity result ��ó
 * @author Sohee Kim
 * @date 2022-04-05
 *
 */
public class P85 {

	public static void main(String[] args) {
		int a = 100;
		double b = 0.0;
//		double result = a / b; // result: infinity 
		//?? �� infinity  ===> infinity�� ������ ch02-P47���� �����Ѵ�.
		
		// infinity ��ó���
		double result = 0.0;
		result = a / b;
		if(Double.isFinite(result)) {
			System.out.println(result);
		}else {
			System.out.println("�и� 0.0�Դϴ�.");
		}
		

	}

}
