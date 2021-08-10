package guru.springframework.reactivebeerclient.model.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

/*
    created by jhcue at 09/08/2021
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
    private UUID id;
    private String beerName;
    private BeerStyleEnum beerStyle;
    private String upc;
    private BigDecimal price;
    private Integer quantityOnHand;
}
