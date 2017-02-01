package com.robert.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessorDTO {

    private Long id;

    private String  producer;

    private String processorFamily;

    private String model;

    private int cores;

    private int threads;

    private double processorBaseFrequency;

    private double maxTurboFrequency;

    private int cache;

    private int lithography;

    private String processorGraphics;

    private int TDP;
}
