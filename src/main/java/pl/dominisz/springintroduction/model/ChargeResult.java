package pl.dominisz.springintroduction.model;

public class ChargeResult {
    private final boolean successful;
    private final String declinedMessage;

    public ChargeResult(boolean successful, String declinedMessage) {
        this.successful = successful;
        this.declinedMessage = declinedMessage;
    }

    public String getDeclinedMessage() {
        return declinedMessage;
    }

    public boolean isSuccessful() {
        return successful;
    }

}
