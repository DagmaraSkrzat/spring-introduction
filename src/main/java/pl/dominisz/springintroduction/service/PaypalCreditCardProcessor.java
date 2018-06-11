package pl.dominisz.springintroduction.service;

import org.springframework.stereotype.Component;
import pl.dominisz.springintroduction.model.ChargeResult;
import pl.dominisz.springintroduction.model.CreditCard;

import java.math.BigDecimal;

@Component
public class PaypalCreditCardProcessor implements CreditCardProcessor {

    public PaypalCreditCardProcessor() {
        System.out.println("PaypalCreditCardProcessor");
    }

    @Override
    public ChargeResult charge(CreditCard creditCard, BigDecimal amount) {
        //obciążenie karty poprzez Paypal
        return null;
    }
}
