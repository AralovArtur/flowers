package com.artur.flowers.controllers;

import com.artur.flowers.models.Product;
import com.artur.flowers.repositories.OrderLineRepository;
import com.artur.flowers.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderLineController {
    @Autowired
    private OrderLineRepository orderLineRepository;

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/orderlines/relatedProducts/")
    public List<Product> getRelatedProducts(@RequestParam("id") Long id) {
        List<Long> IDOfRelatedProducts = orderLineRepository.findIdOfRelatedProducts(id);
        return (List<Product>) productRepository.findAllById(IDOfRelatedProducts);
    }
}
