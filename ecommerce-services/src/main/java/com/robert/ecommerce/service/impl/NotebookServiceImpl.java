package com.robert.ecommerce.service.impl;

import com.robert.ecommerce.dto.FullNotebookDTO;
import com.robert.ecommerce.dto.MinimalismNotebookDTO;
import com.robert.ecommerce.entity.NotebookEntity;
import com.robert.ecommerce.repository.NotebookRepository;
import com.robert.ecommerce.service.NotebookService;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NotebookServiceImpl implements NotebookService {


    final NotebookRepository notebookRepository;
    final MapperFacade mapper;

    @Autowired
    public NotebookServiceImpl(NotebookRepository notebookRepository, MapperFacade mapper) {
        this.notebookRepository = notebookRepository;
        this.mapper = mapper;
    }

    @Override
    public boolean addNotebook(FullNotebookDTO notebook) {
        NotebookEntity newNotebook = mapper.map(notebook, NotebookEntity.class);
        notebookRepository.save(newNotebook);
        return true;
    }

    @Override
    public FullNotebookDTO findProductById(Long id) {
        return mapper.map(notebookRepository.findOne(id), FullNotebookDTO.class);
    }

    @Override
    public List<MinimalismNotebookDTO> findAllNotebook(Pageable pageable) {
        Page<NotebookEntity> notebook = notebookRepository.findAll(pageable);

        return mapper.mapAsList(notebook.getContent(), MinimalismNotebookDTO.class);
    }
}
