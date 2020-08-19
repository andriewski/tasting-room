package by.mark.tastingroom.services;

import guru.model.BeerPagedList;
import guru.model.BeerStyle;
import org.springframework.data.domain.PageRequest;

public interface BeerService {

    BeerPagedList getAllBeer(String beerName, BeerStyle beerStyle, PageRequest pageRequest, Boolean showInventoryOnHand);
}