package ch05;
/**
 * String�� ���
 * @author noran
 *
 */
public class P148 {

	public static void main(String[] args) {
		String str = "abcde";
		int c = str.indexOf("c");	// c�� ���°��? (index 0��������)
		System.out.println(c);
		
		String str2 = str.substring(0,2);	// 0��°���� 2��° �������� => ab
		System.out.println(str2);
		
		String mail = "jmlee@tonesol.com";
		String id = mail.substring(0, mail.indexOf("@"));
		String domain = mail.substring(mail.indexOf("@") + 1, mail.indexOf("."));
		
		// mail���� id�κ� �̾Ƴ���				--> substring(index, index)�� �׳� ���� �̸����� �ٲ�� �Ұ���
		/*int s = 0;
		while(mail.charAt(s) != '@') {
			id += mail.charAt(s);
			s++;
		}
		
		// mail���� domain�κ� �̾Ƴ���
		for(int i = mail.indexOf("@") + 1; i < mail.length(); i++) {
			if(mail.charAt(i) == '.') {
				break;
			}
			domain+= mail.charAt(i);
		} */
		System.out.printf("%s  %s", id,domain);
		
		String ss = "   abc   ";
		System.out.println(ss.trim());	// ������ �����ش�
	}

}
