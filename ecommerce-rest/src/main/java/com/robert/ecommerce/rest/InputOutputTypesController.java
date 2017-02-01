package com.robert.ecommerce.rest;

import com.robert.ecommerce.dto.InputOutputTypesDTO;
import com.robert.ecommerce.service.InputOutputTypesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class InputOutputTypesController {

    @Autowired
    private InputOutputTypesService inputOutputTypesService;

//    @RequestMapping(method = GET, path = "api/admin/inputsOutput", produces = APPLICATION_JSON_VALUE)
    @RequestMapping(method = GET, path = "api/all/inputsOutput", produces = APPLICATION_JSON_VALUE)
    public List<InputOutputTypesDTO> getAllInputsOutputsTypes() {
        return inputOutputTypesService.getInputOutputTypes();
    }

//    @RequestMapping(method = POST, path = "api/admin/addInputsOutput", produces = APPLICATION_JSON_VALUE)
    @RequestMapping(method = POST, path = "api/all/inputsOutput", produces = APPLICATION_JSON_VALUE)
    public InputOutputTypesDTO addNewInputOutput(@RequestBody InputOutputTypesDTO typesDTO) {
        return inputOutputTypesService.addInputOutputType(typesDTO);
    }
}
