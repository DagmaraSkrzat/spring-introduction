package pl.dominisz.springintroduction.repository;

import lombok.Builder;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Repository;
import pl.dominisz.springintroduction.exception.PizzaOrderNotFoundException;
import pl.dominisz.springintroduction.model.PizzaOrder;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * http://dominisz.pl
 * 07.06.2018
 */

//@Repository ze Spring-data  tworzy dynamicznie klasę (bo ta adnotacja jest nad interfejsem),
//        która obsługuje bazę danych wykonując zapytania, które generuje na podstawie nazw metod tego interfejsu.
//        Powoduje też, że wyjątki związane z bazą danych są zamieniane na Springowe DataAccessExceptions.
@Builder
@Repository
public class InMemoryPizzaOrderRepository implements PizzaOrderRepository {

    private List<PizzaOrder> pizzaOrders;

    public InMemoryPizzaOrderRepository() {
        pizzaOrders = new ArrayList<>();

        PizzaOrder order = PizzaOrder.builder()
                .id(1L)
                .orderDateTime(LocalDateTime.now())
                .item("Pizza Margerita")
                .item("Pepsi")
                .item("Beer")
                .amount(new BigDecimal(25))
                .build();
        pizzaOrders.add(order);

        order = PizzaOrder.builder()
                .id(2L)
                .orderDateTime(LocalDateTime.now())
                .item("Pizza Hawajska")
                .item("Herbata")
                .amount(new BigDecimal(20))
                .build();
        pizzaOrders.add(order);


        order = PizzaOrder.builder()
                .id(3L)
                .orderDateTime(LocalDateTime.now())
                .item("Pizza z czosnkiem")
                .item("Woda z gazem")
                .amount(new BigDecimal(40))
                .build();
        pizzaOrders.add(order);

        //do poprawki, bo konstruktor się zmienił i doszły pola w konstruktorze PizzaOrder
//        pizzaOrders.add(new PizzaOrder(1L, "Pizza Margherita", new BigDecimal(25)));
//        pizzaOrders.add(new PizzaOrder(2L, "Pizza Hawajska", new BigDecimal(25)));
//        pizzaOrders.add(new PizzaOrder(3L, "Pizza Diablo", new BigDecimal(25)));
    }

    public List<PizzaOrder> findAll() {
        return pizzaOrders;
    }

    public PizzaOrder findById(Long id) {
        //zwróci nam oryginał, ten który się znajduje w liście (jeśli oczywiście znajdzie go w liście)
        return pizzaOrders.stream()
                .filter(pizzaOrder -> pizzaOrder.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new PizzaOrderNotFoundException());
    }

    public PizzaOrder save(PizzaOrder pizzaOrder) {

        if (pizzaOrder.getId() == null) {
            Long maxId = pizzaOrders.stream()
                    .mapToLong(PizzaOrder::getId)
                    .max()
                    .orElse(1);

            //    public long orElse(long other) {
            //        return isPresent ? value : other;
            //    }
            // Return the value if present, otherwise invoke (odwołać się) {@code other} and return
            // the result of that invocation.

            pizzaOrder.setId(maxId + 1);
            pizzaOrders.add(pizzaOrder);
        }
        return pizzaOrder;
    }

    //to nie powinno tu być chyba:
    @Override
    public List<PizzaOrder> searchByCompleted(boolean completed) {
        List<PizzaOrder> completedOrders = pizzaOrders.stream()
                .filter(pizzaOrder -> pizzaOrder.isCompleted() == (completed))
                .collect(Collectors.toList());
        return completedOrders;
    }



}