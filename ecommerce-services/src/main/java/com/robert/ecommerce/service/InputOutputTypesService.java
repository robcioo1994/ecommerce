package com.robert.ecommerce.service;


import com.robert.ecommerce.dto.InputOutputTypesDTO;

import java.util.List;

public interface InputOutputTypesService {

    List<InputOutputTypesDTO> getInputOutputTypes();

    InputOutputTypesDTO addInputOutputType(InputOutputTypesDTO typesDTO);
}
