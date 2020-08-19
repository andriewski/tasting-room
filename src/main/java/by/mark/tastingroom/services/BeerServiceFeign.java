package by.mark.tastingroom.services;

import guru.model.BeerPagedList;
import guru.model.BeerStyle;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BeerServiceFeign implements BeerService {

    private final BeerServiceFeignClient beerServiceFeignClient;

    @Override
    public BeerPagedList getAllBeer(String beerName, BeerStyle beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand) {
        return beerServiceFeignClient.getAllBeer(beerName, beerStyle, pageRequest, showInventoryOnHand);
    }
}