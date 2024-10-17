//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.time.LocalDate;

class Transaction {
    private String transactionId;
    private String type; // DEPOSIT, withdrawal
    private Double amount;
    private String currency;
    private LocalDate date;
    private String description;

    // Private constructor to enforce use of Builder
    private Transaction(TransactionBuilder builder) {
        this.transactionId = builder.transactionId;
        this.type = builder.type;
        this.amount = builder.amount;
        this.currency = builder.currency;
        this.date = builder.date;
        this.description = builder.description;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getCurrency() {
        return currency;
    }

    public Double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public String getTransactionId() {
        return transactionId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", date=" + date +
                ", description='" + description + '\'' +
                '}';
    }

    // Inner Builder class
    public static class TransactionBuilder {

        //Required
        private final String transactionId;
        private final String type; // DEPOSIT, withdrawal
        private final Double amount;

        //Optional
        private String currency;
        private LocalDate date;
        private String description;

        public TransactionBuilder(String transactionId, String type, Double amount) {
            this.transactionId = transactionId;
            this.type = type;
            this.amount = amount;
        }

        public TransactionBuilder setCurrency(String currency) {
            this.currency = currency;
            return this;
        }

        public TransactionBuilder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public TransactionBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Transaction build() { // Use the builder to create Transaction
            return new Transaction(this);
        }
    }
}


public class Main {
    public static void main(String[] args) {

        // Creating a Transaction using the Builder
        Transaction transaction = new Transaction.TransactionBuilder
                ("T1230", "DEPOSIT", 1000.0).
                setCurrency("INR").
                setDate(LocalDate.of(2024, 10, 11)).
                build();

        System.out.println(transaction.toString());
    }
}