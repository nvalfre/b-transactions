package com.nv.dv.btransactions.dao.cqrs.price.read;

import com.nv.dv.btransactions.domain.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceQueryRepository extends JpaRepository<Price, Long> {
    List<Price> findByStartDateAndProductIdAndBrandId(LocalDateTime startDate, Integer productId, Integer brandId);

    @Override
    default <S extends Price> S save(S price) {
        throw new UnsupportedOperationException("Save operation is not supported");
    }

    @Override
    default <S extends Price> List<S> saveAll(Iterable<S> entities) {
        throw new UnsupportedOperationException("Save operation is not supported");
    }
}
