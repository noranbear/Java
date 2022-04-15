/**
 * 
 */
package ch06;

/**
 *
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 15. 오후 1:10:35
 */
public class BankApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Account acc1 = new Account("1111-2222");
		System.out.println(acc1.toString());
		
		acc1.deposit(10000);
		System.out.println(acc1.toString());
		
		acc1.withdrawl(5500);
		System.out.println(acc1);
		
		String accNo = acc1.getAccNo();
		
		
		double balance = acc1.getBalance();
		System.out.printf("계좌정보: %s, %.2f \n",accNo, balance);
	}

}
