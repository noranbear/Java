package ch04;
/**
 * 
 * Multiplication table example
 * (+) 생각보다 이중포문을 특정분야 외의 현업에서 많이 사용하지 않는다. 두 번 돌아가면 - 2차원, 세 번 - 3차원
 * New concepts: break outter, \t
 * 
 * @author noranbear
 * @date 2022-04-12
 */
public class P124 {

	public static void main(String[] args) {
		
		outter:								// 이름은 원하는 대로 바꿀 수 있다.
		for (int i = 2; i < 10; i++) {		// i 값은 구구단으로 보면 앞의 수를 의미- 2x3=6의 2 2x4=8의 2
			// *짝수단만 찍고 싶다.
			if(i%2 == 1) {
				continue;
			}
			// *5단에서 끝내고 싶다.
//			if(i == 6) {
//				break;
//			}
			System.out.println(i + "단 시작 -------");
			
			for (int j = 1; j < 10; j++) {		
				// *결과28이 나오기 전에 멈춰라.  
				if((i*j) == 28) {
					break outter;			// case1) break; -> 28전에 4단만 멈추고 그 뒤의 단은 정상수행. => break;은 해당 루프(break이 쓰여진)만 나감.
											// case2) break outter; -> 28이 되면 더 이상 진행이 안되고 전체루프(위의 outter: 밑의 루프)에서 나감.
				}
				System.out.printf("%d x %d = %d\t", i,j,(i*j));  	// \t = tab
				
			}
			System.out.println("~~~~~~~~~~~~~~");
		}
	}
}
