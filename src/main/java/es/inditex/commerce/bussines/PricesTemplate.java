package es.inditex.commerce.bussines;

import es.inditex.commerce.dto.PricesDto;

import java.time.LocalDateTime;

public interface PricesTemplate {

    PricesDto findRateByProduct(LocalDateTime startDate, Integer productId, Integer brandId);
}
