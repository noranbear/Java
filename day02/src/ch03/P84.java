package ch03;
/**
 * �����⿡�� ������ ��
 * @author Sohee Kim
 * @date 2022-04-05
 */
public class P84 {
	
	public static void main(String[] args) {
		int a = 10;
		int b = 0;   // Exception: 0���� ���� �� ���� ������ compile error�� ���. (compile error�� �߸�, �� �ٿ��� ���α׷��� �����)
		int c = 3;
		int result = 0;
		double result2 = 0;
		
		// => ������ �� ���ɼ��� �ִ� ���, ��� ����� �Ѵ�.
		if(b != 0) {
			result = a / b;
		}
		  
		result2 = (double)a / (double)c;   // �Ҽ������� ��� ������ �ϳ��ϳ� double�� Ÿ��ĳ������ ����� �Ѵ�.
											// ����� �Ҽ��� �ڸ��� ����������� �ڵ����� �߶�����. -> �׷��Ƿ�, ��𿡼� �߶����� ���ؾ� �Ѵ�.
											// a�� c �� ���� �ϳ��� double�� Ÿ��ĳ���õǾ ����� �Ҽ������� �Ȱ���.
		System.out.println(result);
		System.out.println(result2);
	}
}
