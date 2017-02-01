package com.robert.ecommerce.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemoryDTO {

    private Long id;

    private int amount;

    private String type;

    private int frequency;
}
