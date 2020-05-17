package com.artur.flowers.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @CreationTimestamp
    private Date createdAt;
    private double total;

    public Order(Date createdAt) {
        this.createdAt = createdAt;
    }
}
