package com.robert.ecommerce.service.impl;

import com.robert.ecommerce.dto.HardDiscDTO;
import com.robert.ecommerce.entity.HardDiscEntity;
import com.robert.ecommerce.repository.HardDiscRepository;
import com.robert.ecommerce.service.HardDiscService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HardDiscServiceImpl implements HardDiscService {

    final HardDiscRepository hardDiscRepository;
    final MapperFacade mapper;

    @Autowired
    public HardDiscServiceImpl(HardDiscRepository hardDiscRepository, MapperFacade mapperFacade) {
        this.hardDiscRepository = hardDiscRepository;
        this.mapper = mapperFacade;
    }

    @Override
    public List<HardDiscDTO> getAllHardDisc() {
        return mapper.mapAsList(hardDiscRepository.findAll(),HardDiscDTO.class);
    }

    @Override
    public HardDiscDTO addDisc(HardDiscDTO discDTO) {
        HardDiscEntity accountEntityToAdd = mapper.map(discDTO, HardDiscEntity.class);
        HardDiscEntity save = hardDiscRepository.save(accountEntityToAdd);
        return mapper.map(save, HardDiscDTO.class);
    }
}
