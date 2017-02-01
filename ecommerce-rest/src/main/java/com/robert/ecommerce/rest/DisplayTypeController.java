package com.robert.ecommerce.rest;

import com.robert.ecommerce.dto.DisplayTypeDTO;
import com.robert.ecommerce.service.DisplayTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class DisplayTypeController {

    @Autowired
    private DisplayTypeService displayTypeService;

    //    @RequestMapping(method = GET, path = "api/admin/memory", produces = APPLICATION_JSON_VALUE)
    @RequestMapping(method = GET, path = "api/all/displayType", produces = APPLICATION_JSON_VALUE)
    public List<DisplayTypeDTO> geDisplayTypes() {
        return displayTypeService.geDisplayTypeList();
    }

    //    @RequestMapping(method = POST, path = "api/admin/memory", produces = APPLICATION_JSON_VALUE)
    @RequestMapping(method = POST, path = "api/all/displayType", produces = APPLICATION_JSON_VALUE)
    public DisplayTypeDTO addDisplayType(@RequestBody DisplayTypeDTO displayTypeDTO) {
        return displayTypeService.addDisplayType(displayTypeDTO);
    }
}
