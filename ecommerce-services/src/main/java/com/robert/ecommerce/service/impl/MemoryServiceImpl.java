package com.robert.ecommerce.service.impl;

import com.robert.ecommerce.dto.MemoryDTO;
import com.robert.ecommerce.entity.MemoryEntity;
import com.robert.ecommerce.repository.MemoryRepository;
import com.robert.ecommerce.service.MemoryService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoryServiceImpl implements MemoryService {

    final MemoryRepository memoryRepository;
    final MapperFacade mapper;

    @Autowired
    public MemoryServiceImpl(MemoryRepository memoryRepository, MapperFacade mapper) {
        this.memoryRepository = memoryRepository;
        this.mapper = mapper;
    }

    @Override
    public List<MemoryDTO> getAllMemorys() {
        return mapper.mapAsList(memoryRepository.findAll(), MemoryDTO.class);
    }

    @Override
    public MemoryDTO addMemory(MemoryDTO memoryDTO) {
        MemoryEntity accountEntityToAdd = mapper.map(memoryDTO, MemoryEntity.class);
        MemoryEntity save = memoryRepository.save(accountEntityToAdd);
        return mapper.map(save, MemoryDTO.class);
    }
}
