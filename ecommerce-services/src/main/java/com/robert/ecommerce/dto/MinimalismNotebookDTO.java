package com.robert.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MinimalismNotebookDTO {

    private Long id;

    private String productName;

    private double price;

    private String frontImage;
}
