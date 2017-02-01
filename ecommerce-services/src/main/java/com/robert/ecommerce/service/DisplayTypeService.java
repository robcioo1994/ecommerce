package com.robert.ecommerce.service;


import com.robert.ecommerce.dto.DisplayTypeDTO;

import java.util.List;

public interface DisplayTypeService {

    List<DisplayTypeDTO> geDisplayTypeList();

    DisplayTypeDTO addDisplayType(DisplayTypeDTO displayTypeDTO);
}
