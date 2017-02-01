package com.robert.ecommerce.rest;

import com.robert.ecommerce.dto.MinimalismNotebookDTO;
import com.robert.ecommerce.dto.FullNotebookDTO;
import com.robert.ecommerce.service.NotebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class NotebookController {

    @Autowired
    private NotebookService notebookService;

    @RequestMapping(method = POST, path = "api/all/notebook", produces = APPLICATION_JSON_VALUE)
    public boolean addNoteBook(@RequestBody FullNotebookDTO notebook) {
        return notebookService.addNotebook(notebook);
    }

    @RequestMapping(method = GET, path = "/api/all/notebook/{id}")
    public FullNotebookDTO findNotebookById(@PathVariable Long id) {
        return notebookService.findProductById(id);
    }

    @RequestMapping(method = GET, path = "/api/all/notebooks", produces = APPLICATION_JSON_VALUE)
    public List<MinimalismNotebookDTO> findAllNotebooks(Pageable pageable){
        return notebookService.findAllNotebook(pageable);
    }
}
