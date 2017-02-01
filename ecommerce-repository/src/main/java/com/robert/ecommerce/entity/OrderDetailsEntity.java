package com.robert.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER_ORDERS_DETAILS")
public class OrderDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private NotebookEntity notebook;
    private int amount;
    private double price;

    public OrderDetailsEntity(NotebookEntity notebook, int amount, double price) {
        this.notebook = notebook;
        this.amount = amount;
        this.price = price;
    }
}
