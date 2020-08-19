package by.mark.tastingroom.services;

import guru.model.BeerDto;
import guru.model.BeerOrderDto;
import guru.model.BeerOrderLineDto;
import guru.model.CustomerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TastingRoomService {

    private final CustomerService customerService;
    private final BeerOrderService beerOrderService;
    private final BeerService beerService;

    @Scheduled(fixedRate = 3000)
    public void createOrder() {
        getCustomerDtoIterator()
                .forEachRemaining(customerDto -> {
                    BeerOrderDto randomOrder = getRandomOrder();
                    log.debug("Placing order - customer id: {} and random order: {}", customerDto.getId(), randomOrder);
                    beerOrderService.placeOrder(customerDto.getId(), randomOrder);
                });

    }

    private BeerOrderDto getRandomOrder() {
        BeerDto beerDto = getRandomBeerDto();

        return BeerOrderDto.builder()
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .customerId(UUID.randomUUID())
                .beerOrderLines(List.of(
                        BeerOrderLineDto.builder()
                                .upc(beerDto.getUpc())
                                .beerId(beerDto.getId())
                                .beerName(beerDto.getBeerName())
                                .beerStyle(beerDto.getBeerStyle().toString())
                                .orderQuantity(1)
                                .build()
                ))
                .build();
    }

    private Iterator<CustomerDto> getCustomerDtoIterator() {
        Iterator<CustomerDto> iterator = null;

        while (iterator == null) {
            Iterator<CustomerDto> customerDtoIterator = customerService.getCustomers(
                    PageRequest.of(getRandom(10), 10)
            ).iterator();

            if (customerDtoIterator.hasNext()) {
                iterator = customerDtoIterator;
            }
        }

        return iterator;
    }

    private BeerDto getRandomBeerDto() {
        BeerDto beerDto = null;

        while (beerDto == null) {
            Iterator<BeerDto> iterator = beerService.getAllBeer(
                    null,
                    null,
                    PageRequest.of(getRandom(100), 1),
                    false
            ).iterator();

            if (iterator.hasNext()) {
                beerDto = iterator.next();
            }
        }

        return beerDto;
    }

    private int getRandom(int range) {
        return RandomUtils.nextInt(range) + 1;
    }
}
