package by.mark.tastingroom.services;

import guru.model.BeerOrderDto;
import guru.model.CustomersPagedList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "order-service")
public interface BeerOrderServiceFeignClient {

    @RequestMapping(
            method = RequestMethod.POST,
            value = "/api/v1/customers/{customerId}/orders",
            consumes = APPLICATION_JSON_VALUE
    )
    ResponseEntity<BeerOrderDto> placeOrder(@PathVariable UUID customerId, BeerOrderDto beerOrderDto);

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/v1/customers",
            consumes = APPLICATION_JSON_VALUE
    )
    ResponseEntity<CustomersPagedList> getCustomers(Pageable pageable);
}