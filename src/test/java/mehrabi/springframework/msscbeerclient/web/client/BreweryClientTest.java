package mehrabi.springframework.msscbeerclient.web.client;

import mehrabi.springframework.msscbeerclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    @Test
    void testGetBeerById() {
        BeerDto beerById = breweryClient.getBeerById(UUID.randomUUID());

        assertNotNull(beerById);
    }

    @Test
    void testSaveNewBeer() {
        BeerDto beerById = BeerDto.builder().beerName("New Beer").build();

        URI uri = breweryClient.saveNewBeer(beerById);

        assertNotNull(uri);

        System.out.println(uri.toString());
    }

    @Test
    void testUpdateBeer() {
        BeerDto beerById = BeerDto.builder().beerName("New Beer").build();

        breweryClient.updateBeer(UUID.randomUUID(),beerById);
    }

    @Test
    void testDeleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }
}