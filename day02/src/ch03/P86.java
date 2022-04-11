package ch03;
/**
 * String - 정수, 실수형 변환.
 * @author Sohee KIm
 * @date 2022-04-05
 */
public class P86 {
	
	public static void main(String[] args) {
		String str = "100";
		String str2 = "백";  // 이것을 어떻게 해결할지?
		String str3 = "NaN";  // "NaN"은 특별 케이스 = not a number
		char c = 'A';
		
		int a = c;   // 가능
		System.out.println(a);
		
//		int a = str; 불가능
		int b = Integer.valueOf(str); // String을 int로 바꿀 수 있다. (parseInt, valueOf)
		//int d = Integer.parseInt(str2);
		
		int result = b * 100;
		
		double e = Double.valueOf(str3); // 실수에 NaN 넣기는 가능
		double result2 = 0.0;
		
		if(Double.isNaN(e)) { // is Not a Number (NaN인지 알 수 있는 기능 제공)
			System.out.println("입력 오류");
		}else {
			result2 = a * 100;
		}
		
		// System.out.println(d);
		System.out.println(result);
		System.out.println(result2);
		System.out.println(e);
	}

}
