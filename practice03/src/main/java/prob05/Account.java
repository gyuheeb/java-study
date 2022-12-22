package prob05;

public class Account {
	private String accountNo;
	private int balance;
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
		
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void save(int getBalance) {
		this.balance = + getBalance;
		System.out.println("계좌에 "+ balance+" 만원이 입금되었습니다.");

	}
	public void deposit(int setBalance) {
		this.balance = this.balance- setBalance;
		System.out.println("계좌에 "+ balance+" 만원이 출금되었습니다.");
	
	}
	public Account(String account) {
		this.balance=0;
		this.accountNo= account;
		System.out.println("계좌가 개설되었습니다.");
		
	}
	
	
}
