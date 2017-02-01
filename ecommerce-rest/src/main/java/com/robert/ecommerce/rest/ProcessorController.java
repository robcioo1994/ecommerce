package com.robert.ecommerce.rest;

import com.robert.ecommerce.dto.ProcessorDTO;
import com.robert.ecommerce.service.ProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class ProcessorController {

    @Autowired
    private ProcessorService processorService;

    //    @RequestMapping(method = GET, path = "api/admin/memory", produces = APPLICATION_JSON_VALUE)
    @RequestMapping(method = GET, path = "api/all/processor", produces = APPLICATION_JSON_VALUE)
    public List<ProcessorDTO> getAllProcessors() {
        return processorService.getAllProcessors();
    }

    //    @RequestMapping(method = POST, path = "api/admin/memory", produces = APPLICATION_JSON_VALUE)
    @RequestMapping(method = POST, path = "api/all/processor", produces = APPLICATION_JSON_VALUE)
    public ProcessorDTO addProcessor(@RequestBody ProcessorDTO discDTO) {
        return processorService.addProcessor(discDTO);
    }
}
