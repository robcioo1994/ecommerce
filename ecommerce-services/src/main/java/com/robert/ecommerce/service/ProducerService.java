package com.robert.ecommerce.service;

import com.robert.ecommerce.dto.ProducerDTO;

import java.util.List;

public interface ProducerService {

    List<ProducerDTO> getProducers();

    ProducerDTO addProducer(ProducerDTO producerDTO);
}
