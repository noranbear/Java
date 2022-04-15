/**
 * 
 */
package bank;

/**
 *
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 15. 오전 11:41:35
 */
public class Account {
	
	private String accNo;		// private: 외부로부터 정보에 대한 직접적인 접근을 막는다.
	private double balance;
	
	public Account() {
		
	}
	
	public Account(String accNo) {
		this.accNo = accNo;
	}

	public Account(String accNo, double balance) {
		this.accNo = accNo;
		this.balance = balance;
	}
	
	public void deposit(double money) {
		if(money < 1) {
			System.out.println("입금 금액 오류\n");
			return;
		}
		this.balance += money;
	}
	
	// 출금 금액이 1보다 작으면 안된다.
	// 출금 금액이 잔액보다 많으면 안된다.
	public void withdraw(double money) {
		if(money < 1) {
			System.out.println("입금 금액 오류\n");
			return;
		}
		if(money > this.balance) {
			System.out.println("잔액 부족\n");
			return;
		}
		this.balance -= money;
	}

	// 계좌이기 때문에 보안 상 setters는 만들지 않았다.
	/**
	 * @return the accNo
	 */
	public String getAccNo() {
		return accNo;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	// tools
	
	// 실제 업무에서는 필요없고 그냥 확인용으로 많이 쓰임
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", balance=" + balance + "]";
	}

	
	
	
	
	
}
