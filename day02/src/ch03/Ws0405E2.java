package ch03;
/**
 * How to format decimal number.
 * @author Sohee Kim
 * @date 2022-04-05
 */
public class Ws0405E2 {

	public static void main(String[] args) {
		
			double w = 5;
			double h = 7;
			
			double result = Math.hypot(w, h);
			
			// Using precision format specifier
			System.out.println(String.format("%.2f", result));
			System.out.printf("%.2f%n", result);
			System.out.format("%.2f", result);
	}

}