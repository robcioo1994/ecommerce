package com.robert.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LaptopRecordEntity {

    private Long id;
    private double displayRes;
    private double displaySize;
    private double hddSize;
    private long timeSpent;
}

