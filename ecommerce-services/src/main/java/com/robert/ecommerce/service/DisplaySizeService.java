package com.robert.ecommerce.service;


import com.robert.ecommerce.dto.DisplaySizeDTO;

import java.util.List;

public interface DisplaySizeService {

    List<DisplaySizeDTO> getDisplaySize();

    DisplaySizeDTO addDisplaySize(DisplaySizeDTO displaySizeDTO);
}
