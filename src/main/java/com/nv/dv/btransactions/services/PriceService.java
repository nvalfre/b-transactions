package com.nv.dv.btransactions.services;

import com.nv.dv.btransactions.domain.dto.PriceDTO;

import java.time.LocalDateTime;

public interface PriceService {
    PriceDTO findPriceByDateAndProductAndBrand(LocalDateTime startDate, Integer productId, Integer brandId);
}
