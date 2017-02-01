package com.robert.ecommerce.rest;

import com.robert.ecommerce.dto.ProducerDTO;
import com.robert.ecommerce.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    //    @RequestMapping(method = GET, path = "api/admin/memory", produces = APPLICATION_JSON_VALUE)
    @RequestMapping(method = GET, path = "api/all/producer", produces = APPLICATION_JSON_VALUE)
    public List<ProducerDTO> getProducers() {
        return producerService.getProducers();
    }

    //    @RequestMapping(method = POST, path = "api/admin/memory", produces = APPLICATION_JSON_VALUE)
    @RequestMapping(method = POST, path = "api/all/producer", produces = APPLICATION_JSON_VALUE)
    public ProducerDTO addProducer(@RequestBody ProducerDTO producerDTO) {
        return producerService.addProducer(producerDTO);
    }
}
