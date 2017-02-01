package com.robert.ecommerce.service.impl;

import com.robert.ecommerce.dto.DisplayTypeDTO;
import com.robert.ecommerce.entity.DisplayTypeEntity;
import com.robert.ecommerce.repository.DisplayTypeRepository;
import com.robert.ecommerce.service.DisplayTypeService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisplayTypeServiceImpl implements DisplayTypeService {

    final DisplayTypeRepository typeRepository;
    final MapperFacade mapper;

    @Autowired
    public DisplayTypeServiceImpl(DisplayTypeRepository typeRepository, MapperFacade mapper) {
        this.typeRepository = typeRepository;
        this.mapper = mapper;
    }


    @Override
    public List<DisplayTypeDTO> geDisplayTypeList() {
        return mapper.mapAsList(typeRepository.findAll(), DisplayTypeDTO.class);
    }

    @Override
    public DisplayTypeDTO addDisplayType(DisplayTypeDTO displayTypeDTO) {
        DisplayTypeEntity typeEntity = mapper.map(displayTypeDTO, DisplayTypeEntity.class);
        DisplayTypeEntity save = typeRepository.save(typeEntity);
        return mapper.map(save, DisplayTypeDTO.class);
    }
}
