package com.robert.ecommerce.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PROCESSOR")
public class ProcessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
