package com.nv.dv.btransactions.services.impl;

import com.nv.dv.btransactions.dao.cqrs.price.write.PriceCommandRepository;
import com.nv.dv.btransactions.domain.entity.Price;
import com.nv.dv.btransactions.services.WritePriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WritePriceServiceImpl implements WritePriceService {
    private final PriceCommandRepository priceCommandRepository;

    @Override
    public Price save(Price price) {
        return priceCommandRepository.save(price);
    }
}
