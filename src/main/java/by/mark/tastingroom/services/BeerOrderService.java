package by.mark.tastingroom.services;

import guru.model.BeerOrderDto;

import java.util.UUID;

public interface BeerOrderService {

    BeerOrderDto placeOrder(UUID customerId, BeerOrderDto beerOrderDto);
}