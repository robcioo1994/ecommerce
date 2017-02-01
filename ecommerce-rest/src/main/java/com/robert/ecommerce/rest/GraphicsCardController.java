package com.robert.ecommerce.rest;

import com.robert.ecommerce.dto.GraphicsCartDTO;
import com.robert.ecommerce.service.GraphicsCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
public class GraphicsCardController {

    @Autowired
    private GraphicsCardService graphicsCardService;

    //    @RequestMapping(method = GET, path = "api/admin/memory", produces = APPLICATION_JSON_VALUE)
    @RequestMapping(method = GET, path = "api/all/graphicsCard", produces = APPLICATION_JSON_VALUE)
    public List<GraphicsCartDTO> getGraphicsCarts() {
        return graphicsCardService.getGraphicsCarts();
    }

    //    @RequestMapping(method = POST, path = "api/admin/memory", produces = APPLICATION_JSON_VALUE)
    @RequestMapping(method = POST, path = "api/all/graphicsCard", produces = APPLICATION_JSON_VALUE)
    public GraphicsCartDTO addGraphicsCart(@RequestBody GraphicsCartDTO graphicsCartDTO) {
        return graphicsCardService.addGraphicsCart(graphicsCartDTO);
    }
}
