package com.nv.dv.btransactions.services.impl;
import com.nv.dv.btransactions.domain.entity.Price;
import com.nv.dv.btransactions.domain.dto.PriceDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PricePresenterServiceImplTest {

    @Mock
    private Price price;

    @InjectMocks
    private PricePresenterServiceImpl pricePresenterService;

    @Test
    public void build_ReturnsPriceDTOWithCorrectValues() {
        int productId = 123;
        int brandId = 456;
        BigDecimal priceValue = BigDecimal.valueOf(9.99);
        LocalDateTime now = LocalDateTime.now();

        LocalDateTime expected = now.plusHours(1);
        when(price.getProductId()).thenReturn(productId);
        when(price.getBrandId()).thenReturn(brandId);
        when(price.getPrice()).thenReturn(priceValue);
        when(price.getStartDate()).thenReturn(now);
        when(price.getEndDate()).thenReturn(expected);

        PriceDTO result = pricePresenterService.build(price);

        assertEquals(productId, result.getProductId());
        assertEquals(brandId, result.getBrandId());
        assertEquals(priceValue, result.getPrice());
        assertEquals(now, result.getStartDate());
        assertEquals(expected, result.getEndDate());
    }
}