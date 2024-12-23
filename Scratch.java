class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

class MinimumBalanceException extends Exception {
    public MinimumBalanceException(String message) {
        super(message);
    }
}

class Account {
    private int accountNo;
    private String name;
    private float balance;

    public Account(int accountNo, String name, float balance) {
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
    }

    public void deposit(float amount) throws NegativeNumberException {
        if (amount < 0) {
            throw new NegativeNumberException("Cannot deposit negative amount!");
        }
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }

    public void withdraw(float amount) throws MinimumBalanceException {
        if (balance - amount < 500) {
            throw new MinimumBalanceException("Withdrawal would breach minimum balance of Rs. 500!");
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
    }
}

class Bank {
    public static void main(String[] args) {
        Account account = new Account(12345, "John Doe", 1000);

        try {
            account.deposit(500);
            account.withdraw(700);
            account.withdraw(300); // This will throw an exception
        } catch (NegativeNumberException | MinimumBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
 
