package integration;

import com.nv.dv.btransactions.domain.entity.Price;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CorrectPriceUseCase {

    static final String EXPECTED_OUTPUT_PRICE_1 = "{\"productId\":35455,\"brandId\":1,\"price\":35.50,\"startDate\":\"2020-06-14T00:00:00\",\"endDate\":\"2020-12-31T23:59:59\"}";
    static final String EXPECTED_OUTPUT_PRICE_2 = "{\"productId\":35455,\"brandId\":1,\"price\":25.45,\"startDate\":\"2020-06-14T15:00:00\",\"endDate\":\"2020-06-14T18:30:00\"}";
    static final String EXPECTED_OUTPUT_PRICE_3 = "{\"productId\":35455,\"brandId\":1,\"price\":30.50,\"startDate\":\"2020-06-15T00:00:00\",\"endDate\":\"2020-06-15T11:00:00\"}";
    static final String EXPECTED_OUTPUT_PRICE_4 = "{\"productId\":35455,\"brandId\":1,\"price\":38.95,\"startDate\":\"2020-06-15T16:00:00\",\"endDate\":\"2020-12-31T23:59:59\"}";
    static final Price SCENARIO_1 = new Price(1L, 1, LocalDateTime.parse("2020-06-14T00:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"),
            1, 35455, 0, new BigDecimal("35.50"), "EUR");
    static final Price SCENARIO_2 = new Price(2L, 1, LocalDateTime.parse("2020-06-14T15:00:00"), LocalDateTime.parse("2020-06-14T18:30:00"),
            2, 35455, 1, new BigDecimal("25.45"), "EUR");
    static final Price SCENARIO_3 = new Price(3L, 1, LocalDateTime.parse("2020-06-15T00:00:00"), LocalDateTime.parse("2020-06-15T11:00:00"),
            3, 35455, 1, new BigDecimal("30.50"), "EUR");
    static final Price SCENARIO_4 = new Price(4L, 1, LocalDateTime.parse("2020-06-15T16:00:00"), LocalDateTime.parse("2020-12-31T23:59:59"),
            4, 35455, 1, new BigDecimal("38.95"), "EUR");

}
