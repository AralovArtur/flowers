package com.artur.flowers.controllers;

import com.artur.flowers.models.Order;
import com.artur.flowers.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/orders/")
    public List<Order> getPaginatedOrders(@RequestParam("page") Optional<Integer> pageNumber, @RequestParam("size") Optional<Integer> pageSize) {
        Pageable paging = PageRequest.of(pageNumber.orElse(0), pageSize.orElse(5));
        Page<Order> pagedResult = orderRepository.findAll(paging);
        return pagedResult.toList();
    }
}