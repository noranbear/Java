/**
 * 
 */
package bank;

/**
 *
 * @author noranbear (norandoly@gmail.com)
 * @since 2022. 4. 15. ���� 11:41:35
 */
public class Account {
	
	private String accNo;		// private: �ܺηκ��� ������ ���� �������� ������ ���´�.
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
			System.out.println("�Ա� �ݾ� ����\n");
			return;
		}
		this.balance += money;
	}
	
	// ��� �ݾ��� 1���� ������ �ȵȴ�.
	// ��� �ݾ��� �ܾ׺��� ������ �ȵȴ�.
	public void withdraw(double money) {
		if(money < 1) {
			System.out.println("�Ա� �ݾ� ����\n");
			return;
		}
		if(money > this.balance) {
			System.out.println("�ܾ� ����\n");
			return;
		}
		this.balance -= money;
	}

	// �����̱� ������ ���� �� setters�� ������ �ʾҴ�.
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
	
	// ���� ���������� �ʿ���� �׳� Ȯ�ο����� ���� ����
	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", balance=" + balance + "]";
	}

	
	
	
	
	
}
