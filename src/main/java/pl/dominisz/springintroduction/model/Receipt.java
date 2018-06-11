package pl.dominisz.springintroduction.model;

import java.math.BigDecimal;

public class Receipt {

    private final boolean successful;
    private final BigDecimal amount;
    private final String message;

    public Receipt(boolean successful, BigDecimal amount, String message) {
        this.successful = successful;
        this.amount = amount;
        this.message = message;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public static Receipt forSuccessfulCharge(BigDecimal amount) {
        return new Receipt(true, amount, "");
    }

    public static Receipt forDeclinedCharge(String declinedMessage) {
        return new Receipt(false, BigDecimal.ZERO, declinedMessage);
    }

    public static Receipt forSystemFailure(String message) {
        return new Receipt(false, BigDecimal.ZERO, message);
    }


}
