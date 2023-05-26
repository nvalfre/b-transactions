package com.nv.dv.btransactions.dao.cqrs.price.write;

import com.nv.dv.btransactions.domain.entity.Price;
import io.micrometer.common.lang.NonNullApi;
import org.springframework.data.jpa.repository.JpaRepository;

@NonNullApi
public interface PriceCommandRepository extends JpaRepository<Price, Long> {
    <S extends Price> S save(S price);
}
