package pl.dominisz.springintroduction.service;

import org.springframework.stereotype.Component;
import pl.dominisz.springintroduction.exception.UnreachableException;
import pl.dominisz.springintroduction.model.ChargeResult;

@Component
public class DatabaseTransactionLog implements TransactionLog{

    public DatabaseTransactionLog() {
        System.out.println("DatabaseTransationLon");
    }

    @Override
    public void logChargeResult(ChargeResult result) {
        //zapisz do bazy danych
    }

    @Override
    public void logConnectException(UnreachableException e) {
        //zapisz informacje o błędzie do bazy danych
    }
}
