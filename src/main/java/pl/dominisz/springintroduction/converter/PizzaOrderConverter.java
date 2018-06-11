package pl.dominisz.springintroduction.converter;

import org.springframework.stereotype.Component;
import pl.dominisz.springintroduction.model.PizzaOrder;
import pl.dominisz.springintroduction.model.PizzaOrderDTO;

@Component
public class PizzaOrderConverter {

    public PizzaOrder convert(PizzaOrderDTO pizzaOrderDTO) {
        PizzaOrder pizzaOrder = new PizzaOrder();

        pizzaOrder.setItems(pizzaOrderDTO.getItems());
        pizzaOrder.setAmount(pizzaOrderDTO.getAmout());

        return pizzaOrder;
    }

}
