package ch04;

import java.util.Scanner;

/**
 * while�̶�� �ݺ����� �̿��Ͽ� �츮�� ���� ���� �����̶� �����غ��Ҵ�.
 * @author Sohee Kim
 * @date 2022-04-11
 */
public class P127 {

	public static void main(String[] args) {
		System.out.println("Start...");
		Scanner sc = new Scanner(System.in);
		
		while(true) {		// ture -> while ��� ����. => ���ѷ��� -> �޸����� ���� �� �ý����� ����ִ�. �� ����.
			System.out.println("Input cmd(w1,w2,q)...");		// ���� ���࿡���� ������ �̷��� ��ü�ߴ�.
			String cmd = sc.next();							// -> ��������� ���̸� �ᰮ���ָ� ������� �̷� �ڵ带 �Ἥ ������.
			
			if(cmd.equals("q")) {				// ���� �� ������ ���� // exit�� �� �� case�� ���� exit�ϱ� ���� �� ���鼭 ã�ư� �ʿ� x
				System.out.println("Bye...");
				break;
			}else if(cmd.equals("w1")) {
				System.out.println("W1 Input number..");
				String snum = sc.next();
				System.out.println(snum);
			}else if(cmd.equals("w2")) {
				System.out.println("W2 Input number..");
				String snum = sc.next();
				System.out.println(snum);
			}
		}
		
		sc.close();
		System.out.println("End..."); // error(Unreachable code): ���ѷ��� �ؿ� �� ���� ������ ����. 
									  // --> ������ ���� �� �ִ� ������ ����� ������ ������.

	}

}
