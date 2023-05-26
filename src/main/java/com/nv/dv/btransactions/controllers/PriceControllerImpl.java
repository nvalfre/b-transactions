package com.nv.dv.btransactions.controllers;

import com.nv.dv.btransactions.domain.dto.PriceDTO;
import com.nv.dv.btransactions.services.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prices")
public class PriceControllerImpl extends AbstractController implements PriceController {
    private final PriceService priceService;

    @GetMapping
    public ResponseEntity<PriceDTO> getPrice(
            @RequestParam("start_date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam("product_id") Integer productId,
            @RequestParam("brand_id") Integer brandId) {
        final PriceDTO price = priceService.findPriceByDateAndProductAndBrand(startDate, productId, brandId);
        return ResponseEntity.ok(price);
    }
}
