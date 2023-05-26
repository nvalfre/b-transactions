package com.nv.dv.btransactions.controllers;

import com.nv.dv.btransactions.domain.dto.PriceDTO;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public interface PriceController {
    ResponseEntity<PriceDTO> getPrice(
            LocalDateTime startDate,
            Integer productId,
            Integer brandId);
}
