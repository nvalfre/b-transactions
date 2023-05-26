package com.nv.dv.btransactions.services;

import com.nv.dv.btransactions.domain.entity.Price;
import com.nv.dv.btransactions.domain.dto.PriceDTO;

public interface PricePresenterService {
    PriceDTO build(Price price);
}
