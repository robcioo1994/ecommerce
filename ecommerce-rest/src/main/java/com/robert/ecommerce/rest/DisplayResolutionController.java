package com.robert.ecommerce.rest;

import com.robert.ecommerce.dto.DisplayResolutionDTO;
import com.robert.ecommerce.service.DisplayResolutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class DisplayResolutionController {

    @Autowired
    private DisplayResolutionService resolutionService;

    //    @RequestMapping(method = GET, path = "api/admin/memory", produces = APPLICATION_JSON_VALUE)
    @RequestMapping(method = GET, path = "api/all/displayResolution", produces = APPLICATION_JSON_VALUE)
    public List<DisplayResolutionDTO> getAlDisplayResolution() {
        return resolutionService.getDisplayResolutions();
    }

    //    @RequestMapping(method = POST, path = "api/admin/memory", produces = APPLICATION_JSON_VALUE)
    @RequestMapping(method = POST, path = "api/all/displayResolution", produces = APPLICATION_JSON_VALUE)
    public DisplayResolutionDTO addDisplayResolution(@RequestBody DisplayResolutionDTO resolutionDTO) {
        return resolutionService.addDisplayResolution(resolutionDTO);
    }
}
