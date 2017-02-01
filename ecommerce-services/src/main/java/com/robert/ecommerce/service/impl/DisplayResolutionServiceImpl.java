package com.robert.ecommerce.service.impl;

import com.robert.ecommerce.dto.DisplayResolutionDTO;
import com.robert.ecommerce.entity.DisplayResolutionEntity;
import com.robert.ecommerce.repository.DisplayResolutionRepository;
import com.robert.ecommerce.service.DisplayResolutionService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisplayResolutionServiceImpl implements DisplayResolutionService {

    final DisplayResolutionRepository resolutionRepository;
    final MapperFacade mapper;

    @Autowired
    public DisplayResolutionServiceImpl(DisplayResolutionRepository resolutionRepository, MapperFacade mapper) {
        this.resolutionRepository = resolutionRepository;
        this.mapper = mapper;
    }

    @Override
    public List<DisplayResolutionDTO> getDisplayResolutions() {
        return mapper.mapAsList(resolutionRepository.findAll(), DisplayResolutionDTO.class);
    }

    @Override
    public DisplayResolutionDTO addDisplayResolution(DisplayResolutionDTO resolutionDTO) {
        DisplayResolutionEntity displayResolutionEntity = mapper.map(resolutionDTO, DisplayResolutionEntity.class);
        DisplayResolutionEntity save = resolutionRepository.save(displayResolutionEntity);
        return mapper.map(save, DisplayResolutionDTO.class);
    }
}
