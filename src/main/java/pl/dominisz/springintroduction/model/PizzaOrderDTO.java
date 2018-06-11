package pl.dominisz.springintroduction.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PizzaOrderDTO {

    private String description;
    private BigDecimal amount;

    public String getItems() {
        return description;
    }

    public BigDecimal getAmout() {
        return amount;
    }
}
