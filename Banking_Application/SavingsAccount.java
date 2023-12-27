package Assignment.Assignment2;

class SavingsAccount extends Account {
    public SavingsAccount(double balance) {
        super(balance);
    }

    public void calculateInterest() {
        double interest = balance * 0.07;
        balance += interest;
        System.out.println("Interest Added: Rs." + interest);
    }
}
