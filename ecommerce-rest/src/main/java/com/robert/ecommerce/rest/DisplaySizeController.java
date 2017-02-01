package com.robert.ecommerce.rest;

import com.robert.ecommerce.dto.DisplaySizeDTO;
import com.robert.ecommerce.service.DisplaySizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class DisplaySizeController {

    @Autowired
    private DisplaySizeService displaySizeService;

    //    @RequestMapping(method = GET, path = "api/admin/memory", produces = APPLICATION_JSON_VALUE)
    @RequestMapping(method = GET, path = "api/all/displaySize", produces = APPLICATION_JSON_VALUE)
    public List<DisplaySizeDTO> getAllDisplaySizes() {
        return displaySizeService.getDisplaySize();
    }

    //    @RequestMapping(method = POST, path = "api/admin/memory", produces = APPLICATION_JSON_VALUE)
    @RequestMapping(method = POST, path = "api/all/displaySize", produces = APPLICATION_JSON_VALUE)
    public DisplaySizeDTO addDisplaySize(@RequestBody DisplaySizeDTO displaySizeDTO) {
        return displaySizeService.addDisplaySize(displaySizeDTO);
    }
}
