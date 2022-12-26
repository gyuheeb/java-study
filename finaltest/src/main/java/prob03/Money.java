package prob03;

public class Money {
	private int amount;


	 public Money(int i) {
		this.amount=i;
		
	}

	public Money multiply(Money money) {
		Money m=new Money(this.amount*money.getAmount());
			return m;
		}

		public Money devide(Money money) {
			Money m=new Money(this.amount/money.getAmount());
			return m;
			
		}

		public Money add(Money money) {
			Money m=new Money(this.amount+money.getAmount());
			return m;
		}
		public Money minus(Money money) {
			Money m=new Money(this.amount-money.getAmount());
			return m;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}
		
		public boolean equals(Money money) {
			
			return this.amount == money.getAmount();
		}

	
	
	/* 코드 작성 */
}
