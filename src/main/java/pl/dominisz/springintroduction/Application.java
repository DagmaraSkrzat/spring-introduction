package pl.dominisz.springintroduction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import pl.dominisz.springintroduction.model.CreditCard;
import pl.dominisz.springintroduction.model.PizzaOrder;
import pl.dominisz.springintroduction.model.Receipt;
import pl.dominisz.springintroduction.service.*;

import java.math.BigDecimal;

//@ComponentScan                  //Spring przeszukuje ten pakiet i wszystkie podpakiety w celu znalezieniakomponentów
                                //Tak, więc oprócz oznaczenia klas z adnotacją Component, trzeba również oznaczyć klasę z adnotacją
                                //ComponentScan

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        //To co poniżej zakomentowane to nie potrzebne przy adnotacji: @SpringBootApplication, potrzebne było przy adnotacji @ComponentScan
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Application.class);
//
//        BillingService billingService = applicationContext.getBean(CreditCardBillingService.class);
//        //poniższa linijka zostaje zastąpiona powyższą:
//        //BillingService billingService = new CreditCardBillingService(creditCardProcessor, transactionLog);
//        // teraz już nie tworzymy obiektu za pomocą new
//        //tylko wyciągamy tak jakby z kontenera tą zawartość, którą chcemy
//        //w tym przypadku : applicationContext.getBean(CreditCardBillingService.class)
//
//
//        PizzaOrder pizzaOrder = new PizzaOrder("Pizza Margerita", BigDecimal.TEN);
//        CreditCard creditCard = new CreditCard();
//
//        Receipt receipt = billingService.chargeOrder(pizzaOrder, creditCard);
//
//        System.out.println(receipt);


        SpringApplication.run(Application.class);

    }

}
