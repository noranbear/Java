package ch03;
/**
 * infinity result 대처
 * @author Sohee Kim
 * @date 2022-04-05
 *
 */
public class P85 {

	public static void main(String[] args) {
		int a = 100;
		double b = 0.0;
//		double result = a / b; // result: infinity 
		//?? 왜 infinity  ===> infinity의 이유는 ch02-P47에서 설명한다.
		
		// infinity 대처방법
		double result = 0.0;
		result = a / b;
		if(Double.isFinite(result)) {
			System.out.println(result);
		}else {
			System.out.println("분모가 0.0입니다.");
		}
		

	}

}
