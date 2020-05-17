package com.artur.flowers.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "orderlines")
@Getter
@Setter
@NoArgsConstructor
public class OrderLine {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Product product;
    private double subtotal;
    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    public OrderLine(Product product, double subtotal, Order order) {
        this.product = product;
        this.subtotal = subtotal;
        this.order = order;
    }
}
