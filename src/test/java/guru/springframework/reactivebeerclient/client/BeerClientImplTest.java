package guru.springframework.reactivebeerclient.client;

import guru.springframework.reactivebeerclient.config.WebClientConfig;
import guru.springframework.reactivebeerclient.model.BeerPagedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/*
    created by jhcue at 09/08/2021
*/
public class BeerClientImplTest {

    BeerClientImpl beerClient;

    @BeforeEach
    void setUp() {
        beerClient = new BeerClientImpl(new WebClientConfig().provideWebClient());
    }

    @Test
    void listBeers() {
        Mono<BeerPagedList> beerPagedListMono = beerClient.listBeers(null, null, null, null, null);

        var pagedList = beerPagedListMono.block();
        assertAll(
                () -> assertThat(pagedList).isNotNull(),
                () -> assertThat(pagedList.getContent()).isNotNull().isNotEmpty()
        );
        pagedList.getContent().forEach(beerDto -> System.out.println(beerDto.toString()));
    }

   @Test
    void listBeersPageSize10() {
        Mono<BeerPagedList> beerPagedListMono = beerClient.listBeers(1, 10, null, null, null);

        var pagedList = beerPagedListMono.block();
        assertAll(
                () -> assertThat(pagedList).isNotNull(),
                () -> assertThat(pagedList.getContent().size()).isEqualTo(10)
        );
    }

   @Test
    void listBeersNoRecords() {
        Mono<BeerPagedList> beerPagedListMono = beerClient.listBeers(10, 10, null, null, null);

        var pagedList = beerPagedListMono.block();
        assertAll(
                () -> assertThat(pagedList).isNotNull(),
                () -> assertThat(pagedList.getContent()).isEmpty()
        );
    }

    @Test
    void getBeerByIdNotFound() {
        final var id = UUID.randomUUID(); // Expected not found on the database, but still a valid UUID
        var beerMono = beerClient.getBeerById(id, null);
        var beerDto = beerMono.block();
        assertNull(beerDto.getId());
    }

    @Test
    void getBeerById() {
        var monoBeerPagedList = beerClient.listBeers(null, 1, null, null, null);
        var beerPagedList = monoBeerPagedList.block();
        final var id = beerPagedList.getContent().get(0).getId();
        var beerMono = beerClient.getBeerById(id, null);
        var beerDto = beerMono.block();
        assertEquals(id, beerDto.getId());
    }

    @Test
    void createBeer() {

    }

    @Test
    void updateBeer() {

    }

    @Test
    void deleteBeerById() {

    }

    @Test
    void getBeerByUPC() {
        var monoBeerPagedList = beerClient.listBeers(null, 1, null, null, null);
        var beerPagedList = monoBeerPagedList.block();
        final var upc = beerPagedList.getContent().get(0).getUpc();
        var beerMono = beerClient.getBeerByUPC(upc);
        var beerDto = beerMono.block();
        assertEquals(upc, beerDto.getUpc());
    }
}
