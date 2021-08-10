package guru.springframework.reactivebeerclient.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

/*
    created by jhcue at 08/08/2021
*/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
    @Null
    private UUID id;
    private String beerName;
    private String beerStyle;
    private String upc;
    private BigDecimal price;
    private Integer quantityOnHand;
    private OffsetDateTime createdDate;
    private OffsetDateTime lastUpdateDate;
}
