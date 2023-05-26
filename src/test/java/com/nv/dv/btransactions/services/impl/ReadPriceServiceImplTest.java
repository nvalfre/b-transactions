package com.nv.dv.btransactions.services.impl;

import com.nv.dv.btransactions.dao.cqrs.price.read.PriceQueryRepository;
import com.nv.dv.btransactions.domain.entity.Price;
import com.nv.dv.btransactions.exceptions.PriceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReadPriceServiceImplTest {

    @Mock
    private PriceQueryRepository priceRepository;

    @InjectMocks
    private ReadPriceServiceImpl readPriceService;

    @Test
    public void findPriceByDateAndProductAndBrand_ReturnsPrice() {
        LocalDateTime startDate = LocalDateTime.of(2023, 1, 1, 0, 0);
        int productId = 123;
        int brandId = 456;

        Price expectedPrice = new Price();

        List<Price> prices = new ArrayList<>();
        prices.add(expectedPrice);
        when(priceRepository.findByStartDateAndProductIdAndBrandId(startDate, productId, brandId)).thenReturn(prices);

        Price result = readPriceService.findPriceByDateAndProductAndBrand(startDate, productId, brandId);

        assertEquals(expectedPrice, result);
    }

    @Test
    public void findPriceByDateAndProductAndBrand_ThrowsPriceNotFoundException() {
        LocalDateTime startDate = LocalDateTime.of(2023, 1, 1, 0, 0);
        int productId = 123;
        int brandId = 456;

        when(priceRepository.findByStartDateAndProductIdAndBrandId(startDate, productId, brandId)).thenReturn(new ArrayList<>());

        assertThrows(PriceNotFoundException.class, () ->
                readPriceService.findPriceByDateAndProductAndBrand(startDate, productId, brandId));
    }
}