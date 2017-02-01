package com.robert.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoggingDTO {

    private Long id;

    private String email;

    private Long productId;

    private double time;

}
