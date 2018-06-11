package pl.dominisz.springintroduction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dominisz.springintroduction.model.ChargeResult;
import pl.dominisz.springintroduction.model.CreditCard;
import pl.dominisz.springintroduction.model.PizzaOrder;
import pl.dominisz.springintroduction.model.Receipt;
import pl.dominisz.springintroduction.exception.UnreachableException;

@Component      //taka adnotacja mówi o tym, że dana klasa ma być zarządzana przez bin (?) Springa (że jest to obiekt zarządzany przez Springa)
public class CreditCardBillingService implements BillingService {

    private final CreditCardProcessor creditCardProcessor;
    private final TransactionLog transactionLog;

    @Autowired          //adnotacja @Autowired powoduje, że Spring
                        //widzi, że trzeba udostępnić konstruktorowi obiekty typu CreditCardProcessor oraz TransactionLog
                        //a z kolei nad każdą z klas CreditCardProcessor oraz TransactionLog mamy adnotację @Component
                        //i to z kolei powoduje, że Spring stworzy nam obiekty tego typu (nie potrzeba słówka new)
    public CreditCardBillingService(CreditCardProcessor creditCardProcessor, TransactionLog transactionLog) {
        System.out.println("CreditCardBillingService");
        this.creditCardProcessor = creditCardProcessor;
        this.transactionLog = transactionLog;
    }

    public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {

        try {
            ChargeResult result = creditCardProcessor.charge(creditCard, order.getAmount());
            transactionLog.logChargeResult(result);

            return result.isSuccessful()
                    ? Receipt.forSuccessfulCharge(order.getAmount())
                    : Receipt.forDeclinedCharge(result.getDeclinedMessage());
        } catch (UnreachableException e) {
            transactionLog.logConnectException(e);
            return Receipt.forSystemFailure(e.getMessage());
        }
    }

}
