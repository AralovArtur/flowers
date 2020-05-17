package com.artur.flowers.repositories;

import com.artur.flowers.models.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
