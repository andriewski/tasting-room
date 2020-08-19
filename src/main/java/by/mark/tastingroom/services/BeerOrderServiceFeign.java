package by.mark.tastingroom.services;

import guru.model.BeerOrderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BeerOrderServiceFeign implements BeerOrderService {

    private final BeerOrderServiceFeignClient beerOrderServiceFeignClient;

    @Override
    public BeerOrderDto placeOrder(UUID customerId, BeerOrderDto beerOrderDto) {
        return beerOrderServiceFeignClient.placeOrder(customerId, beerOrderDto).getBody();
    }
}
