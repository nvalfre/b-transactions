package com.nv.dv.btransactions.services.impl;
import com.nv.dv.btransactions.domain.dto.PriceDTO;
import com.nv.dv.btransactions.domain.entity.Price;
import com.nv.dv.btransactions.services.PricePresenterService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PriceServiceImplTest {

    @Mock
    private ReadPriceServiceImpl readPriceService;

    @Mock
    private PricePresenterService pricePresenterService;

    @InjectMocks
    private PriceServiceImpl priceService;

    @Test
    public void findPriceByDateAndProductAndBrand_ReturnsPriceDTO() {
        LocalDateTime startDate = LocalDateTime.of(2023, 1, 1, 0, 0);
        int productId = 123;
        int brandId = 456;

        Price price = new Price();
        PriceDTO expectedPriceDTO = PriceDTO.builder().build();

        when(readPriceService.findPriceByDateAndProductAndBrand(startDate, productId, brandId)).thenReturn(price);
        when(pricePresenterService.build(price)).thenReturn(expectedPriceDTO);

        PriceDTO result = priceService.findPriceByDateAndProductAndBrand(startDate, productId, brandId);

        assertEquals(expectedPriceDTO, result);
    }
}