package mehrabi.springframework.msscbeerclient.web.client;

import mehrabi.springframework.msscbeerclient.web.model.BeerDto;
import mehrabi.springframework.msscbeerclient.web.model.CustomerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "sfg.brewery",ignoreUnknownFields = false)
public class BreweryClient {

    public static final String BEER_PATH = "/api/v1/beer/";
    public static final String CUSTOMER_PATH = "/api/v1/customer/";
    private String apiHost;

    private final RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public URI saveNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apiHost+BEER_PATH,beerDto);
    }

    public void updateBeer(UUID uuid,BeerDto beerDto){
        restTemplate.put(apiHost+BEER_PATH+uuid.toString(),beerDto);
    }

    public void deleteBeer(UUID uuid){
        restTemplate.delete(apiHost+BEER_PATH+uuid);
    }

    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(apiHost+BEER_PATH+uuid.toString(),BeerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(apiHost+CUSTOMER_PATH,customerDto);
    }

    public void updateCustomer(UUID uuid,CustomerDto customerDto){
        restTemplate.put(apiHost+CUSTOMER_PATH+uuid.toString(),customerDto);
    }

    public void deleteCustomer(UUID uuid){
        restTemplate.delete(apiHost+CUSTOMER_PATH+uuid);
    }

    public CustomerDto getCustomerById(UUID uuid){
        return restTemplate.getForObject(apiHost+CUSTOMER_PATH+uuid.toString(),CustomerDto.class);
    }
}
