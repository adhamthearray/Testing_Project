public class Account {

    private double balance;
    private String status; // "Verified", "Suspended", "Closed"

    public Account(double initialBalance, String initialStatus) {
        this.balance = initialBalance;
        this.status = initialStatus;
    }

    public boolean deposit(double amount) {
        if (status.equals("Closed") || amount <= 0) {
            return false;
        }
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (status.equals("Closed") || status.equals("Suspended")) {
            return false;
        }
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // =========================
    // Credit Score Feature
    // =========================
    public int getCreditScore() {
        switch(status) {
            case "Verified":
                return 50 + (int)(Math.random() * 51); // 50-100
            case "Suspended":
                return (int)(Math.random() * 50);      // 0-49
            case "Closed":
                throw new IllegalStateException("Cannot retrieve credit score for closed account");
            default:
                throw new IllegalArgumentException("Invalid account status");
        }
    }
}
