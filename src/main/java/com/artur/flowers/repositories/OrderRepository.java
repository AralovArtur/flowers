package com.artur.flowers.repositories;

import com.artur.flowers.models.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
}
