package com.robert.ecommerce.service.impl;

import com.robert.ecommerce.dto.MemoryDTO;
import com.robert.ecommerce.dto.OperatingSystemDTO;
import com.robert.ecommerce.entity.MemoryEntity;
import com.robert.ecommerce.entity.OperatingSystemEntity;
import com.robert.ecommerce.repository.OperatingSystemRepository;
import com.robert.ecommerce.service.OperatingSystemService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperatingSystemServiceImpl implements OperatingSystemService {

    final OperatingSystemRepository operatingSystemRepository;
    final MapperFacade mapper;

    @Autowired
    public OperatingSystemServiceImpl(OperatingSystemRepository operatingSystemRepository, MapperFacade mapper) {
        this.operatingSystemRepository = operatingSystemRepository;
        this.mapper = mapper;
    }

    @Override
    public List<OperatingSystemDTO> getOperatingSystems() {
        return mapper.mapAsList(operatingSystemRepository.findAll(), OperatingSystemDTO.class);
    }

    @Override
    public OperatingSystemDTO addOperatingSystem(OperatingSystemDTO operatingSystemDTO) {
        OperatingSystemEntity operatingSystemEntity = mapper.map(operatingSystemDTO, OperatingSystemEntity.class);
        OperatingSystemEntity save = operatingSystemRepository.save(operatingSystemEntity);
        return mapper.map(save, OperatingSystemDTO.class);
    }
}
