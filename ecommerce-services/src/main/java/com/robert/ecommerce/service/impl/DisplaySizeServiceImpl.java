package com.robert.ecommerce.service.impl;

import com.robert.ecommerce.dto.DisplaySizeDTO;
import com.robert.ecommerce.entity.DisplaySizeEntity;
import com.robert.ecommerce.repository.DisplaySizeRepository;
import com.robert.ecommerce.service.DisplaySizeService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisplaySizeServiceImpl implements DisplaySizeService {

    final DisplaySizeRepository sizeRepository;
    final MapperFacade mapper;

    @Autowired
    public DisplaySizeServiceImpl(DisplaySizeRepository sizeRepository, MapperFacade mapper) {
        this.sizeRepository = sizeRepository;
        this.mapper = mapper;
    }

    @Override
    public List<DisplaySizeDTO> getDisplaySize() {
        return mapper.mapAsList(sizeRepository.findAll(), DisplaySizeDTO.class);
    }

    @Override
    public DisplaySizeDTO addDisplaySize(DisplaySizeDTO displaySizeDTO) {
        DisplaySizeEntity sizeEntity = mapper.map(displaySizeDTO, DisplaySizeEntity.class);
        DisplaySizeEntity save = sizeRepository.save(sizeEntity);
        return mapper.map(save, DisplaySizeDTO.class);
    }
}
