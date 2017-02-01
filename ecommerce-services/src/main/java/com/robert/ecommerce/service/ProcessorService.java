package com.robert.ecommerce.service;

import com.robert.ecommerce.dto.ProcessorDTO;

import java.util.List;

public interface ProcessorService {

    List<ProcessorDTO> getAllProcessors();

    ProcessorDTO addProcessor(ProcessorDTO processor);

    ProcessorDTO findProductById(Long id);

}
