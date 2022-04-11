package ch02;
/**
 * Char type (ASCII & Unicode)
 * @author Sohee Kim
 * @date 2022-04-05
 */
public class P39 {

	public static void main(String[] args) {
//		byte b1 = 128; error
		byte b1 = 127;
		System.out.println(b1);
		System.out.println();

//		char c1 = 'AB'; It's not a character. It's for only one alphabet.
		char c1 = 'A';
		char c2 = 65; // ASCII of 'A'
		char c3 = '\u0041'; // Unicode of 'A'
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println();
		
		// '°¡'
		char c4 = '\uAC00';
		char c5 = 44032;
		System.out.println(c4);
		System.out.println(c5);
	}

}
