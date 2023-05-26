package com.nv.dv.btransactions.services.impl;

import com.nv.dv.btransactions.domain.entity.Price;
import com.nv.dv.btransactions.domain.dto.PriceDTO;
import com.nv.dv.btransactions.services.PricePresenterService;
import com.nv.dv.btransactions.services.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {
    private final ReadPriceServiceImpl readPriceService;
    private final PricePresenterService pricePresenterService;


    @Override
    public PriceDTO findPriceByDateAndProductAndBrand(LocalDateTime startDate, Integer productId, Integer brandId) {
        final Price price = readPriceService.findPriceByDateAndProductAndBrand(startDate, productId, brandId);
        return pricePresenterService.build(price);
    }
}
