package Assignment.Assignment2;

class CurrentAccount extends Account {
	 public CurrentAccount(double balance) {
	        super(balance);
	  }

	   public void deductFee(double amount) {
	        double fee = (amount - 50000) / 10000 * 5;
	        balance -= fee;
	        System.out.println("Transaction Fee Deducted: Rs." + fee);
	    }
}
