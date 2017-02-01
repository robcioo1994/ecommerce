package com.robert.ecommerce.utils.converter;

import com.robert.ecommerce.dto.MinimalismNotebookDTO;
import com.robert.ecommerce.entity.NotebookEntity;
import com.robert.ecommerce.repository.ProducerRepository;
import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.metadata.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class MinimalismNotebookConverter extends CustomConverter<NotebookEntity, MinimalismNotebookDTO> {

    @Autowired
    private ProducerRepository producerRepository;

    @Override
    public MinimalismNotebookDTO convert(NotebookEntity notebookEntity, Type<? extends MinimalismNotebookDTO> type) {
        MinimalismNotebookDTO notebookDTO = new MinimalismNotebookDTO();
        notebookDTO.setId(notebookEntity.getId());
        notebookDTO.setFrontImage(Base64.getEncoder().encodeToString(notebookEntity.getFrontImage()));
        notebookDTO.setPrice(notebookEntity.getPrice());
        notebookDTO.setProductName(notebookEntity.getProducer().getProducer() + " " + notebookEntity.getProductName());
        return notebookDTO;
    }
}
