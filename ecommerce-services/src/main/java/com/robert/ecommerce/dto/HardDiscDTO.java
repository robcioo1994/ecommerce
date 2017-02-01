package com.robert.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HardDiscDTO {

    private Long id;

    private int size;

    private String type;

    private String input;
}
