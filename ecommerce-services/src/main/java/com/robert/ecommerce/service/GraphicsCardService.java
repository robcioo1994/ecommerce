package com.robert.ecommerce.service;

import com.robert.ecommerce.dto.GraphicsCartDTO;

import java.util.List;

public interface GraphicsCardService {

    List<GraphicsCartDTO> getGraphicsCarts();

    GraphicsCartDTO addGraphicsCart(GraphicsCartDTO graphicsCart);
}
