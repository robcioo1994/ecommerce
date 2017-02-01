package com.robert.ecommerce.service;


import com.robert.ecommerce.dto.OperatingSystemDTO;

import java.util.List;

public interface OperatingSystemService {

    List<OperatingSystemDTO> getOperatingSystems();

    OperatingSystemDTO addOperatingSystem(OperatingSystemDTO operatingSystemDTO);
}
