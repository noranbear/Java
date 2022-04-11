package ch02;
/**
 * Boolean data type
 * @author Sohee Kim
 * @date 2022-04-05
 */
public class P48 {

	public static void main(String[] args) {
		boolean b1 = true;   // or false
		System.out.println(b1);
		
		if(b1){
			System.out.println("First");
		}else{
			System.out.println("Second");
		}
		
		System.out.println("\nGets max and min value:");
		// Integer = class (offered from JRE Library(JRE - base - java.lang - Integer))
		// Prints out the maximum value of integer data type.
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(Byte.MAX_VALUE);
		System.out.println(Byte.MIN_VALUE);
		System.out.println(Long.MAX_VALUE);

	}

}
