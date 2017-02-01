package com.robert.ecommerce.service;


import com.robert.ecommerce.dto.DisplayResolutionDTO;

import java.util.List;

public interface DisplayResolutionService {

    List<DisplayResolutionDTO> getDisplayResolutions();

    DisplayResolutionDTO addDisplayResolution(DisplayResolutionDTO resolutionDTO);
}
