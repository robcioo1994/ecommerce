package com.robert.ecommerce.service.impl;

import com.robert.ecommerce.dto.DisplayTypeDTO;
import com.robert.ecommerce.dto.GraphicsCartDTO;
import com.robert.ecommerce.entity.DisplayTypeEntity;
import com.robert.ecommerce.entity.GraphicsCartEntity;
import com.robert.ecommerce.repository.GraphicsCartRepository;
import com.robert.ecommerce.service.GraphicsCardService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GraphicsCardServiceImpl implements GraphicsCardService {

    final GraphicsCartRepository graphicsCartRepository;
    final MapperFacade mapper;

    @Autowired
    public GraphicsCardServiceImpl(GraphicsCartRepository graphicsCartRepository, MapperFacade mapper) {
        this.graphicsCartRepository = graphicsCartRepository;
        this.mapper = mapper;
    }

    @Override
    public List<GraphicsCartDTO> getGraphicsCarts() {
        return mapper.mapAsList(graphicsCartRepository.findAll(), GraphicsCartDTO.class);
    }

    @Override
    public GraphicsCartDTO addGraphicsCart(GraphicsCartDTO graphicsCart) {
        GraphicsCartEntity graphicsCartEntity = mapper.map(graphicsCart, GraphicsCartEntity.class);
        GraphicsCartEntity save = graphicsCartRepository.save(graphicsCartEntity);
        return mapper.map(save, GraphicsCartDTO.class);
    }
}
