package com.nv.dv.btransactions.services.impl;

import com.nv.dv.btransactions.domain.entity.Price;
import com.nv.dv.btransactions.domain.dto.PriceDTO;
import com.nv.dv.btransactions.services.PricePresenterService;
import org.springframework.stereotype.Service;

@Service
public class PricePresenterServiceImpl implements PricePresenterService {

    @Override
    public PriceDTO build(Price price) {
        return PriceDTO.builder()
                .productId(price.getProductId())
                .brandId(price.getBrandId())
                .price(price.getPrice())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .build();
    }
}
