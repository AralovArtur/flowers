package com.artur.flowers;

import com.artur.flowers.models.Order;
import com.artur.flowers.models.OrderLine;
import com.artur.flowers.models.Product;
import com.artur.flowers.repositories.OrderLineRepository;
import com.artur.flowers.repositories.OrderRepository;
import com.artur.flowers.repositories.ProductRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class FlowersApplication implements CommandLineRunner {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderLineRepository orderLineRepository;


    public static void main(String[] args) {
        SpringApplication.run(FlowersApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Random r = new Random();
        generateProducts(r);
        generateOrders(r);

        List<Product> listOfProducts = (List<Product>) productRepository.findAll();
        List<Order> listOfOrders = (List<Order>) orderRepository.findAll();

        generateOrderLines(r, listOfProducts, listOfOrders);
    }

    public void generateProducts(Random r) {
        int quantity = r.nextInt(101) + 20;

        for (int i = 0; i < quantity; i++) {
            String name = RandomStringUtils.randomAlphanumeric(r.nextInt(10) + 3);
            int stock = r.nextInt(51) + 1;
            double price = 10 + (101 - 10) * r.nextDouble();
            productRepository.save(new Product(name, stock, price));
        }
    }

    public void generateOrders(Random r) {
        int quantity = r.nextInt(51) + 20;

        for (int i = 0; i < quantity; i++) {
            Date createdAt = new Date();
            orderRepository.save(new Order(createdAt));
        }
    }

    public void generateOrderLines(Random r, List<Product> productList, List<Order> orderList) {
        for (Order order: orderList) {
            int quantity = r.nextInt(21) + 1;
            int orderTotal = 0;

            for (int i = 0; i < quantity; i ++) {
                Product product = productList.get(r.nextInt(productList.size()) + 0);
                int numberOfOrderedProducts = r.nextInt(20) + 1;
                double subTotal = product.getPrice() * numberOfOrderedProducts;
                orderTotal += subTotal;
                orderLineRepository.save(new OrderLine(product, subTotal, order));
            }

            order.setTotal(orderTotal);
            orderRepository.save(order);
        }
    }
}