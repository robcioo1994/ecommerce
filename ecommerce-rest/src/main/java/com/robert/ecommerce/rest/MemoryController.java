package com.robert.ecommerce.rest;

import com.robert.ecommerce.dto.MemoryDTO;
import com.robert.ecommerce.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class MemoryController {

    @Autowired
    private MemoryService memoryService;

    //    @RequestMapping(method = GET, path = "api/admin/memory", produces = APPLICATION_JSON_VALUE)
    @RequestMapping(method = GET, path = "api/all/memory", produces = APPLICATION_JSON_VALUE)
    public List<MemoryDTO> getAllMemory() {
        return memoryService.getAllMemorys();
    }

    //    @RequestMapping(method = POST, path = "api/admin/memory", produces = APPLICATION_JSON_VALUE)
    @RequestMapping(method = POST, path = "api/all/memory", produces = APPLICATION_JSON_VALUE)
    public MemoryDTO addMemory(@RequestBody MemoryDTO memoryDTO) {
        return memoryService.addMemory(memoryDTO);
    }
}
