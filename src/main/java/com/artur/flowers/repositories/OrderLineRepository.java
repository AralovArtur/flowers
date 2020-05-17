package com.artur.flowers.repositories;

import com.artur.flowers.models.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {

    @Query(value = "select product_id from (select distinct product_id, count(order_id) as count from orderlines where exists(select order_id from orderlines where product_id = :id) and product_id != :id group by product_id order by count DESC) as related_products_id", nativeQuery = true)
    List<Long> findIdOfRelatedProducts(@Param("id") Long id);
}
