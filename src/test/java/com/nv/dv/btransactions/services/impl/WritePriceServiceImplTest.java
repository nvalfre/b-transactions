package com.nv.dv.btransactions.services.impl;

import com.nv.dv.btransactions.dao.cqrs.price.write.PriceCommandRepository;
import com.nv.dv.btransactions.domain.entity.Price;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class WritePriceServiceImplTest {

    @Mock
    private PriceCommandRepository priceCommandRepository;

    @InjectMocks
    private WritePriceServiceImpl writePriceService;

    @Test
    public void save_ReturnsSavedPrice() {
        Price price = new Price();
        when(priceCommandRepository.save(price)).thenReturn(price);

        Price result = writePriceService.save(price);

        assertEquals(price, result);
        verify(priceCommandRepository, times(1)).save(price);
    }
}