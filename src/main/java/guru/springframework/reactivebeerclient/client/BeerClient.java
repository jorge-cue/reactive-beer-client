package guru.springframework.reactivebeerclient.client;

import guru.springframework.reactivebeerclient.model.BeerPagedList;
import guru.springframework.reactivebeerclient.model.BeerDto;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.UUID;

/*
    created by jhcue at 09/08/2021
*/
public interface BeerClient {

    Mono<BeerDto> getBeerById(UUID id, Boolean showInventoryOnHand);

    Mono<BeerPagedList> listBeers(Integer pageNumber, Integer pageSize, String beerName,
                                  String beerStyle, Boolean showInventoryOnhand);

    Mono<ResponseEntity<BeerDto>> createBeer(BeerDto beerDto);

    Mono<ResponseEntity<BeerDto>> updateBeer(BeerDto beerDto);

    Mono<ResponseEntity<Void>> deleteBeerById(UUID id);

    Mono<BeerDto> getBeerByUPC(String upc);
}
