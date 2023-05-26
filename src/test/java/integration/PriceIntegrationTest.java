package integration;

import com.nv.dv.btransactions.BTransactionsApplication;
import com.nv.dv.btransactions.dao.cqrs.price.read.PriceQueryRepository;
import com.nv.dv.btransactions.dao.cqrs.price.write.PriceCommandRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static integration.CorrectPriceUseCase.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ContextConfiguration(classes = {BTransactionsApplication.class})
@SpringBootTest
@AutoConfigureMockMvc
public class PriceIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PriceQueryRepository priceQueryRepository;

    @Autowired
    private PriceCommandRepository priceCommandRepository;

    @BeforeEach
    public void setUp() {
        priceCommandRepository.saveAll(Arrays.asList(SCENARIO_1, SCENARIO_2, SCENARIO_3, SCENARIO_4));
    }

    @Test
    public void testGetPrice_ReturnsCorrectPrice() throws Exception {
        // Scenario 1
        assertCorrecPriceUseCase("2020-06-14T00:00:00", 35455, 1, EXPECTED_OUTPUT_PRICE_1);

        // Scenario 2
        assertCorrecPriceUseCase("2020-06-14T15:00:00", 35455, 1, EXPECTED_OUTPUT_PRICE_2);

        // Scenario 3
        assertCorrecPriceUseCase("2020-06-15T00:00:00", 35455, 1, EXPECTED_OUTPUT_PRICE_3);

        // Scenario 4
        assertCorrecPriceUseCase("2020-06-15T16:00:00", 35455, 1, EXPECTED_OUTPUT_PRICE_4);
    }

    private void assertCorrecPriceUseCase(String dateTime, int productId, int brandId, String expectedOutput) throws Exception {
        mockMvc.perform(get("/prices")
                        .param("start_date", dateTime)
                        .param("product_id", String.valueOf(productId))
                        .param("brand_id", String.valueOf(brandId)))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedOutput));
    }
}
