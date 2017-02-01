package com.robert.ecommerce.service;


import com.robert.ecommerce.dto.HardDiscDTO;

import java.util.List;

public interface HardDiscService {

    List<HardDiscDTO> getAllHardDisc();

    HardDiscDTO addDisc(HardDiscDTO discDTO);
}
