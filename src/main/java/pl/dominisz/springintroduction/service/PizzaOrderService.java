
package pl.dominisz.springintroduction.service;

import pl.dominisz.springintroduction.model.PizzaOrder;

import java.util.List;

/**
 * http://dominisz.pl
 * 07.06.2018
 */
public interface PizzaOrderService {
    List<PizzaOrder> findAll();

    PizzaOrder create(PizzaOrder pizzaOrder);

    PizzaOrder findByID(Long id);

    public PizzaOrder completeOrder(Long id);

    List<PizzaOrder> searchPizzaOrders(boolean completed);

    void deleteById(Long id);

//    List<PizzaOrder> searchPizzaOrders(boolean completed);
//
//    void deleteById(Long id);
}