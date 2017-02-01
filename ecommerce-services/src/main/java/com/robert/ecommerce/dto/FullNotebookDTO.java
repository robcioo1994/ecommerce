package com.robert.ecommerce.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FullNotebookDTO {

    private Long id;

    private String productName;

    private double price;

    private ProducerDTO producer;

    private ProcessorDTO cpu;

    private MemoryDTO memory;

    private int maxMemory;

    private HardDiscDTO hardDisc;

    private boolean hasDvdRecorder;

    private DisplayTypeDTO displayType;

    private DisplaySizeDTO displaySize;

    private DisplayResolutionDTO displayResolution;

    private GraphicsCartDTO gpu;

    private List<InputOutputTypesDTO> inputOutputTypes;

    private OperatingSystemDTO operatingSystem;

    private double height;

    private double width;

    private double depth;

    private double weight;

    private String color;

    private int guarantee;

    private String  frontImage;

    private List<DescriptionDTO> additionalDescription;

    private List<ImagesDTO> images;
}
