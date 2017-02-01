package com.robert.ecommerce.rest;

import com.robert.ecommerce.dto.HardDiscDTO;
import com.robert.ecommerce.service.HardDiscService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class HardDiscController {

    @Autowired
    private HardDiscService hardDiscService;

    //    @RequestMapping(method = GET, path = "api/admin/memory", produces = APPLICATION_JSON_VALUE)
    @RequestMapping(method = GET, path = "api/all/hardDisc", produces = APPLICATION_JSON_VALUE)
    public List<HardDiscDTO> getAllMemory() {
        return hardDiscService.getAllHardDisc();
    }

    //    @RequestMapping(method = POST, path = "api/admin/memory", produces = APPLICATION_JSON_VALUE)
    @RequestMapping(method = POST, path = "api/all/hardDisc", produces = APPLICATION_JSON_VALUE)
    public HardDiscDTO addNewDisc(@RequestBody HardDiscDTO discDTO) {
        return hardDiscService.addDisc(discDTO);
    }
}
