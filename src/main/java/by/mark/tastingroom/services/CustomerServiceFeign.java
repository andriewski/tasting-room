package by.mark.tastingroom.services;

import guru.model.CustomersPagedList;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceFeign implements CustomerService {

    private final BeerOrderServiceFeignClient beerOrderServiceFeignClient;

    @Override
    public CustomersPagedList getCustomers(Pageable pageable) {
        return beerOrderServiceFeignClient.getCustomers(pageable).getBody();
    }
}
