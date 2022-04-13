package ch05;

import java.util.Random;

/**
 * 이차원 배열
 * @author noran
 *
 */
public class P153 {

	public static void main(String[] args) {
		
//		int ar [] = new int[];		// 1차원 배열
		
		// int ar[][] = new int[3][3]; // 밑에 4줄과 같은 뜻.
		int ar [][] = new int [3][];	// 다차원 배열 - 첫 박스가 행
		ar[0] = new int[3];		// 항상 행이 먼저 만들어지고 각각의 행에 열이 만들어진다.
		ar[1] = new int[3];
		ar[2] = new int[3];		// 2차원 배열
		
		// 값을 넣어보자.	// 현업에선 이런 거 안함.
//		ar[1][2] = 100;
//		ar[0][1] = 200;
		
		Random ran = new Random();
		// 이중 for문을 이용하여 이차원 배열에 값 집어넣기
		// 0
		// 1
		// 2
		for (int i = 0; i < ar.length; i++) {
			
			// 0, 1, 2
			for (int j = 0; j < ar[i].length; j++) {
				ar[i][j] = ran.nextInt(9)+1;
				System.out.print(ar[i][j]+ "\t");
			}
			System.out.println();
		}
//		System.out.println(Arrays.toString(ar));	// 안찍힘
		
		// for문을 이용하여 합과 평균을 구하시오.
		double sum = 0.0;
		int cnt = 0;
		for(int i = 0; i < ar.length; i++) {		// ar.length: 첫 행의 사이즈를 알려줌 - 메모리 그림으로 이해하면 쉬움 ar에 연결 되어있는 주소가 가리키는 1행(3개)의 사이즈.
													// ar.length = ar[][j].length일 것이다 만약 우리가 j를 위에 쓸 수 있다면.
			for(int j =0; j < ar[i].length; j++) {
				sum += ar[i][j];
				cnt ++;
			}
		}
		System.out.printf("합: %.0f\n평균: %.2f\n", sum, sum/cnt);
		System.out.printf("평균2: %.2f\n", sum/(ar.length *ar[0].length));
		

	}

}
