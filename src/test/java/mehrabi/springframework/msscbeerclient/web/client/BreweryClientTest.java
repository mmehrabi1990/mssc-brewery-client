package mehrabi.springframework.msscbeerclient.web.client;

import mehrabi.springframework.msscbeerclient.web.model.BeerDto;
import mehrabi.springframework.msscbeerclient.web.model.CustomerDto;
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

    @Test
    void testGetCustomerById() {
        CustomerDto customerById = breweryClient.getCustomerById(UUID.randomUUID());

        assertNotNull(customerById);
    }

    @Test
    void testSaveNewCustomer() {
        CustomerDto customerById = CustomerDto.builder().customerName("joe").build();

        URI uri = breweryClient.saveNewCustomer(customerById);

        assertNotNull(uri);

        System.out.println(uri.toString());
    }

    @Test
    void testUpdateCustomer() {
        CustomerDto customerById = CustomerDto.builder().customerName("jim").build();

        breweryClient.updateCustomer(UUID.randomUUID(),customerById);
    }

    @Test
    void testDeleteCustomer() {
        breweryClient.deleteCustomer(UUID.randomUUID());
    }
}