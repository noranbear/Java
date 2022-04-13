package ch05;
/**
 * String의 기능
 * @author noran
 *
 */
public class P148 {

	public static void main(String[] args) {
		String str = "abcde";
		int c = str.indexOf("c");	// c는 몇번째니? (index 0에서부터)
		System.out.println(c);
		
		String str2 = str.substring(0,2);	// 0번째부터 2번째 이전까지 => ab
		System.out.println(str2);
		
		String mail = "jmlee@tonesol.com";
		String id = mail.substring(0, mail.indexOf("@"));
		String domain = mail.substring(mail.indexOf("@") + 1, mail.indexOf("."));
		
		// mail에서 id부분 뽑아내기				--> substring(index, index)를 그냥 쓰면 이메일이 바뀌면 불가능
		/*int s = 0;
		while(mail.charAt(s) != '@') {
			id += mail.charAt(s);
			s++;
		}
		
		// mail에서 domain부분 뽑아내기
		for(int i = mail.indexOf("@") + 1; i < mail.length(); i++) {
			if(mail.charAt(i) == '.') {
				break;
			}
			domain+= mail.charAt(i);
		} */
		System.out.printf("%s  %s", id,domain);
		
		String ss = "   abc   ";
		System.out.println(ss.trim());	// 공백을 없애준다
	}

}
