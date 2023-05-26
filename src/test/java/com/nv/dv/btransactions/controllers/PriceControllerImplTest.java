package com.nv.dv.btransactions.controllers;
import com.nv.dv.btransactions.domain.dto.PriceDTO;
import com.nv.dv.btransactions.services.PriceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PriceControllerImplTest {

    @Mock
    private PriceService priceService;

    @InjectMocks
    private PriceControllerImpl priceController;

    @Test
    public void getPrice_ReturnsPriceDTO() {
        LocalDateTime startDate = LocalDateTime.now();
        Integer productId = 123;
        Integer brandId = 456;
        PriceDTO expectedPriceDTO = PriceDTO.builder().build();

        when(priceService.findPriceByDateAndProductAndBrand(any(LocalDateTime.class), any(Integer.class), any(Integer.class)))
                .thenReturn(expectedPriceDTO);

        ResponseEntity<PriceDTO> response = priceController.getPrice(startDate, productId, brandId);

        assertEquals(expectedPriceDTO, response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }
}
