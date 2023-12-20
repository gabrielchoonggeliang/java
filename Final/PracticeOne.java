class Account {
  private String accountNumber;
  private double accountBalance;

  public Account (String accountNumber, double accountBalance) {
    this.accountNumber = accountNumber;
    this.accountBalance = accountBalance;
  }

  public void setAccountNumber (String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getAccountNumber() {
    return this.accountNumber;
  }

  public void setBalance (double accountBalance) {
    this.accountBalance = accountBalance;
  }

  public double getBalance() {
    return this.accountBalance;
  }

  public void deposit(double depositAmount) {
    this.accountBalance += depositAmount;
  }

  public void withdraw(double withdrawAmount) {

    if (this.accountBalance > withdrawAmount)
      this.accountBalance -= withdrawAmount;
    else
      System.out.println("Poor af");
  }
  
}