package com.nv.dv.btransactions.services;

import com.nv.dv.btransactions.domain.entity.Price;

public interface WritePriceService {
    Price save(Price price);
}
