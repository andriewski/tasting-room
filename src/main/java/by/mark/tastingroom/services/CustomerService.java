package by.mark.tastingroom.services;

import guru.model.CustomersPagedList;
import org.springframework.data.domain.Pageable;

public interface CustomerService {

    CustomersPagedList getCustomers(Pageable pageable);
}
