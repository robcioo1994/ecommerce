package com.robert.ecommerce.service;

import com.robert.ecommerce.dto.MemoryDTO;

import java.util.List;

public interface MemoryService {

    List<MemoryDTO> getAllMemorys();

    MemoryDTO addMemory(MemoryDTO memoryDTO);
}
