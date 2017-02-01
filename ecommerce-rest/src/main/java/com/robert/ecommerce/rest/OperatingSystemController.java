package com.robert.ecommerce.rest;

import com.robert.ecommerce.dto.OperatingSystemDTO;
import com.robert.ecommerce.service.OperatingSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class OperatingSystemController {

    @Autowired
    private OperatingSystemService operatingSystemService;

    //    @RequestMapping(method = GET, path = "api/admin/memory", produces = APPLICATION_JSON_VALUE)
    @RequestMapping(method = GET, path = "api/all/operationSystem", produces = APPLICATION_JSON_VALUE)
    public List<OperatingSystemDTO> getOperatingSystems() {
        return operatingSystemService.getOperatingSystems();
    }

    //    @RequestMapping(method = POST, path = "api/admin/memory", produces = APPLICATION_JSON_VALUE)
    @RequestMapping(method = POST, path = "api/all/operationSystem", produces = APPLICATION_JSON_VALUE)
    public OperatingSystemDTO addOperatingSystem(@RequestBody OperatingSystemDTO operatingSystem) {
        return operatingSystemService.addOperatingSystem(operatingSystem);
    }
}
