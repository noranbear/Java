package ch04;
/**
 * 이중 for문을 이용하여 구구단 나타내기
 * + 생각보다 이중포문을 특정분야 외의 현업에서 많이 사용하지 않는다. 두 번 돌아가면 - 2차원, 세 번 - 3차원
 * @author noranbear
 * @date 2022-04-12
 */
public class P124 {

	public static void main(String[] args) {
		
		outter:	// 이름은 원하는 대로 바꿀 수 있다
		for (int i = 2; i < 10; i++) {		// i 값은 구구단으로 보면 앞의 수를 의미- 2x3=6의 2 2x4=8의 2
			// 짝수단만 찍고 싶다.
			if(i%2 == 1) {
				continue;
			}
			System.out.println(i + "단 시작 -------");
			
			// 5단에서 끝내고 싶다.
//			if(i == 6) {
//				break;
//			}
			
			for (int j = 1; j < 10; j++) {		
				// 결과28이 나오기 전에 멈춰라. // case1) 4단만 멈춘다. -> break;은 그 루프만 나감. 
				if((i*j) == 28) {
					break outter;	// outter가 생기면 루프 전체가 나간다. case2)28이 되면 더 이상 진행이 안되고 나감
				}
				System.out.printf("%d x %d = %d\t", i,j,(i*j));  // \t = tab
				
			}
			System.out.println("~~~~~~~~~~~~~~");
		}

	}

}
