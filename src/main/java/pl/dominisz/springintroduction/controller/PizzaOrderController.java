package pl.dominisz.springintroduction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.dominisz.springintroduction.converter.PizzaOrderConverter;
import pl.dominisz.springintroduction.model.PizzaOrder;
import pl.dominisz.springintroduction.model.PizzaOrderDTO;
import pl.dominisz.springintroduction.service.PizzaOrderService;

import java.util.List;

@RestController
@RequestMapping("/pizzaorders")             //taka adnotacja sprawi, że w adresie w przeglądarce /pizzaorders pojawi się zawsze
                                            //a pozostałe/dalsze rzeczy pojawią się adekwatnie do tego co będziemy mieli w metodach
public class PizzaOrderController {


    private final PizzaOrderService pizzaOrderService;
    private final PizzaOrderConverter pizzaOrderConverter;

        @Autowired
        public PizzaOrderController(PizzaOrderService pizzaOrderService, PizzaOrderConverter pizzaOrderConverter) {
            this.pizzaOrderService = pizzaOrderService;
            this.pizzaOrderConverter = pizzaOrderConverter;
        }


        @RequestMapping(path = "/", method = RequestMethod.GET)
        public List<PizzaOrder> getAllOrders() {
            return pizzaOrderService.findAll();
        }

        @RequestMapping(path = "/{id}")
        public PizzaOrder getOrder(@PathVariable Long id) {
            return pizzaOrderService.findByID(id);
        }

        @PutMapping(path = "/{id}/completed")
        public PizzaOrder completeOrder(@PathVariable Long id) {
            return pizzaOrderService.completeOrder(id);
        }

        @RequestMapping(path = "/", method = RequestMethod.POST)
        public PizzaOrder createOrder(@RequestBody PizzaOrderDTO pizzaOrderDTO) {
            PizzaOrder pizzaOrder = pizzaOrderConverter.convert(pizzaOrderDTO);
            return pizzaOrderService.create(pizzaOrder);
        }


        //te dwie poniższe metody nie powinne być tutaj:
        @GetMapping("/search")
        public List<PizzaOrder> searchPizzaOrders(@RequestParam boolean completed) {
            return pizzaOrderService.searchPizzaOrders(completed);
        }

        @DeleteMapping("/{id}")
        public void deleteById(@PathVariable Long id) {
            pizzaOrderService.deleteById(id);
        }



}
