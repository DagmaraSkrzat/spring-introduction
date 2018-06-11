package pl.dominisz.springintroduction.factory;

import pl.dominisz.springintroduction.service.TransactionLog;

public class TransactionLogFactory {

    public static TransactionLog instance;

    public static void setInstance(TransactionLog transactionLog) {
        instance = transactionLog;
    }

    public static TransactionLog getInstance() {
        return instance;
    }

}
