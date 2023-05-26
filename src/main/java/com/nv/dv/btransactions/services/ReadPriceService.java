package com.nv.dv.btransactions.services;


import com.nv.dv.btransactions.domain.entity.Price;

import java.time.LocalDateTime;

public interface ReadPriceService {
    Price findPriceByDateAndProductAndBrand(LocalDateTime date, Integer productId, Integer brandId);
}
