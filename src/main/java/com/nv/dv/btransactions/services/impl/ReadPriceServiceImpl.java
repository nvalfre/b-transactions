package com.nv.dv.btransactions.services.impl;

import com.nv.dv.btransactions.services.ReadPriceService;
import com.nv.dv.btransactions.dao.cqrs.price.read.PriceQueryRepository;
import com.nv.dv.btransactions.domain.entity.Price;
import com.nv.dv.btransactions.exceptions.PriceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReadPriceServiceImpl implements ReadPriceService {
    private final PriceQueryRepository priceRepository;
    public Price findPriceByDateAndProductAndBrand(LocalDateTime startDate, Integer productId, Integer brandId) {
        final List<Price> prices = priceRepository.findByStartDateAndProductIdAndBrandId(startDate,
                productId, brandId);

        return prices.stream()
                .max(Comparator.comparingInt(Price::getPriority))
                .orElseThrow(() -> new PriceNotFoundException("No price found for the given criteria"));
    }
}
