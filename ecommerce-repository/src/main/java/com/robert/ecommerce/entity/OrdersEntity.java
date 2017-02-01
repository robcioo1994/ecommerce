package com.robert.ecommerce.entity;

import com.robert.ecommerce.entity.type.CartStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER_ORDERS")
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private AccountEntity account;
    @Enumerated(EnumType.STRING)
    private CartStatus status;

    @OneToMany
    private List<OrderDetailsEntity> orderDetails;
    private double totalCost;
}
