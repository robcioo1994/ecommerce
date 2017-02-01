package com.robert.ecommerce.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NOTEBOOK")
public class NotebookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String productName;

    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProducerEntity producer;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProcessorEntity cpu;

    @ManyToOne(fetch = FetchType.LAZY)
    private MemoryEntity memory;

    private int maxMemory;

    @ManyToOne(fetch = FetchType.LAZY)
    private HardDiscEntity hardDisc;

    private boolean hasDvdRecorder;

    @ManyToOne(fetch = FetchType.LAZY)
    private DisplayTypeEntity displayType;

    @ManyToOne(fetch = FetchType.LAZY)
    private DisplaySizeEntity displaySize;

    @ManyToOne(fetch = FetchType.LAZY)
    private DisplayResolutionEntity displayResolution;

    @ManyToOne(fetch = FetchType.LAZY)
    private GraphicsCartEntity gpu;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<InputOutputTypesEntity> inputOutputTypes;

    @ManyToOne(fetch = FetchType.LAZY)
    private OperatingSystemEntity operatingSystem;

    private double height;

    private double width;

    private double depth;

    private double weight;

    private String color;

    private int guarantee;

    @Lob @Basic(fetch = FetchType.LAZY)
    private byte[] frontImage;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<DescriptionEntity> additionalDescription;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ImagesEntity> images;
}
