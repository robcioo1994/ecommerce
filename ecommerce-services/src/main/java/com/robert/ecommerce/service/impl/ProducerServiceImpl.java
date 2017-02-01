package com.robert.ecommerce.service.impl;

import com.robert.ecommerce.dto.ProducerDTO;
import com.robert.ecommerce.entity.ProducerEntity;
import com.robert.ecommerce.repository.ProducerRepository;
import com.robert.ecommerce.service.ProducerService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProducerServiceImpl implements ProducerService {

    final ProducerRepository producerRepository;
    final MapperFacade mapper;

    @Autowired
    public ProducerServiceImpl(ProducerRepository producerRepository, MapperFacade mapper) {
        this.producerRepository = producerRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ProducerDTO> getProducers() {
        return mapper.mapAsList(producerRepository.findAll(), ProducerDTO.class);
    }

    @Override
    public ProducerDTO addProducer(ProducerDTO producerDTO) {
        ProducerEntity producerEntity = mapper.map(producerDTO, ProducerEntity.class);
        ProducerEntity save = producerRepository.save(producerEntity);
        return mapper.map(save, ProducerDTO.class);
    }
}
