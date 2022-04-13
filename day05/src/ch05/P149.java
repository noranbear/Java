package ch05;

import java.util.Arrays;

/**
 * 배열 선언, 배열의 값 보여주기, for loop를 사용해 찍어내기 
 * @author noran
 *
 */
public class P149 {

	public static void main(String[] args) {
		int a = 10;
		
		// int ar [] = {10, 11, 12, 13}; //이런식으로 선언 가능하지만 고정된 값이기 때문에 현업에선 잘 쓰이진 않는다.
		int ar [] =	new int [4]; // 배열(array 선언) -> reference type/  [] ar - 이렇게 선언도 가능
							// 배열이 null이면 아무것도 못함(nullpointerexception). 언제나 첨에 사이즈 선언 ㄱ
		ar[0] = 10;
		ar[1] = 11;
		ar[2] = 12;
		ar[3] = 13;
		
		System.out.println(a);
		System.out.println(ar); // address
		System.out.println(Arrays.toString(ar));  // array 값을 가져올 수 있따
		
		// values in array
		for(int i = 0; i < ar.length; i++) {	// length 뒤에 no 가로
			System.out.println(ar[i]);
			
		}

	}

}
