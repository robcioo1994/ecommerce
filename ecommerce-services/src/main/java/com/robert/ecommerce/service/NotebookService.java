package com.robert.ecommerce.service;

import com.robert.ecommerce.dto.MinimalismNotebookDTO;
import com.robert.ecommerce.dto.FullNotebookDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NotebookService {

    boolean addNotebook(FullNotebookDTO notebook);

    FullNotebookDTO findProductById(Long id);

    List<MinimalismNotebookDTO> findAllNotebook(Pageable pageable);
}
