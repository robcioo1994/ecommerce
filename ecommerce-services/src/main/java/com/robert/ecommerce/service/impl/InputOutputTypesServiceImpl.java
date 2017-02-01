package com.robert.ecommerce.service.impl;

import com.robert.ecommerce.dto.AccountDTO;
import com.robert.ecommerce.dto.InputOutputTypesDTO;
import com.robert.ecommerce.entity.AccountEntity;
import com.robert.ecommerce.entity.InputOutputTypesEntity;
import com.robert.ecommerce.repository.InputOutputTypesRepository;
import com.robert.ecommerce.service.InputOutputTypesService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InputOutputTypesServiceImpl implements InputOutputTypesService {

    final InputOutputTypesRepository inputOutputTypesRepository;
    final MapperFacade mapper;

    @Autowired
    public InputOutputTypesServiceImpl(InputOutputTypesRepository inputOutputTypesRepository, MapperFacade mapper) {
        this.inputOutputTypesRepository = inputOutputTypesRepository;
        this.mapper = mapper;
    }

    @Override
    public List<InputOutputTypesDTO> getInputOutputTypes() {
        return mapper.mapAsList(inputOutputTypesRepository.findAll(), InputOutputTypesDTO.class);
    }

    @Override
    public InputOutputTypesDTO addInputOutputType(InputOutputTypesDTO typesDTO) {
        InputOutputTypesEntity outputTypesEntity = mapper.map(typesDTO, InputOutputTypesEntity.class);
        InputOutputTypesEntity save = inputOutputTypesRepository.save(outputTypesEntity);
        return mapper.map(save, InputOutputTypesDTO.class);
    }
}
