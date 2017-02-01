package com.robert.ecommerce.service.impl;

import com.robert.ecommerce.dto.ProcessorDTO;
import com.robert.ecommerce.entity.ProcessorEntity;
import com.robert.ecommerce.repository.ProcessorRepository;
import com.robert.ecommerce.service.ProcessorService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessorServiceImpl implements ProcessorService {

    final ProcessorRepository processorRepository;
    final MapperFacade mapper;

    @Autowired
    public ProcessorServiceImpl(ProcessorRepository processorRepository, MapperFacade mapper) {
        this.processorRepository = processorRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ProcessorDTO> getAllProcessors() {
        return mapper.mapAsList(processorRepository.findAll(), ProcessorDTO.class);
    }

    @Override
    public ProcessorDTO addProcessor(ProcessorDTO processor) {
        ProcessorEntity processorEntity = mapper.map(processor, ProcessorEntity.class);
        ProcessorEntity save = processorRepository.save(processorEntity);
        return mapper.map(save, ProcessorDTO.class);
    }

    @Override
    public ProcessorDTO findProductById(Long id) {
        return null;
    }
}
