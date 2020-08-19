package by.mark.tastingroom.services;

import guru.model.BeerPagedList;
import guru.model.BeerStyle;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FeignClient(name = "beer-service")
public interface BeerServiceFeignClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/api/v1/beer",
            consumes = APPLICATION_JSON_VALUE
    )
    BeerPagedList getAllBeer(
            @RequestParam("beerName") String beerName,
            @RequestParam("beerStyle") BeerStyle beerStyle,
            @RequestParam("pageRequest") PageRequest pageRequest,
            @RequestParam("showInventoryOnHand") Boolean showInventoryOnHand
    );
}