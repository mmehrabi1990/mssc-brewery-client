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

    private String beerPath;
    private String customerPath;
    private String apiHost;

    private final RestTemplate restTemplate;

    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public void setBeerPath(String beerPath) {
        this.beerPath = beerPath;
    }

    public void setCustomerPath(String customerPath) {
        this.customerPath = customerPath;
    }

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }



    public URI saveNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apiHost+beerPath,beerDto);
    }

    public void updateBeer(UUID uuid,BeerDto beerDto){
        restTemplate.put(apiHost+beerPath+uuid.toString(),beerDto);
    }

    public void deleteBeer(UUID uuid){
        restTemplate.delete(apiHost+beerPath+uuid);
    }

    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(apiHost+beerPath+uuid.toString(),BeerDto.class);
    }

    public URI saveNewCustomer(CustomerDto customerDto){
        return restTemplate.postForLocation(apiHost+customerPath,customerDto);
    }

    public void updateCustomer(UUID uuid,CustomerDto customerDto){
        restTemplate.put(apiHost+customerPath+uuid.toString(),customerDto);
    }

    public void deleteCustomer(UUID uuid){
        restTemplate.delete(apiHost+customerPath+uuid);
    }

    public CustomerDto getCustomerById(UUID uuid){
        return restTemplate.getForObject(apiHost+customerPath+uuid.toString(),CustomerDto.class);
    }
}
