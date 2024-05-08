public class Transaction {
    String sendernomorakun;
    String receivernomorakun;
    double amount;
    String transactionDate;

    Transaction(String sendernomorakun, String receivernomorakun, double amount, String transactionDate) {
        this.sendernomorakun = sendernomorakun;
        this.receivernomorakun = receivernomorakun;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }
}

