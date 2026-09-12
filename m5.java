class FeeAccount {
    String accountId;

    FeeAccount(String accountId) {
        this.accountId = accountId;
    }
}

class HostelFeeAccount extends FeeAccount {
    HostelFeeAccount(String accountId) {
        super(accountId);
    }
}

public class Main {
    static int hostelCount = 0;
    static int dayScholarCount = 0;

    static void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            System.out.println("Paid in two installments (hostel account)");
            hostelCount++;
        } else {
            System.out.println("Paid in one go (day-scholar account)");
            dayScholarCount++;
        }
    }

    public static void main(String[] args) {
        FeeAccount[] accounts = {
            new HostelFeeAccount("H-1"),
            new HostelFeeAccount("H-2"),
            new FeeAccount("D-1"),
            new FeeAccount("D-2")
        };

        for (FeeAccount account : accounts) {
            processPayment(account, 60000);
        }

        System.out.println("Hostel accounts processed: " + hostelCount + " | Day-scholar accounts processed: " + dayScholarCount);
    }
}
