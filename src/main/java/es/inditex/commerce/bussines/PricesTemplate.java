package es.inditex.commerce.bussines;

import es.inditex.commerce.dto.PricesDto;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

public interface PricesTemplate {

    List<PricesDto> findRateByProduct(LocalDateTime startDate, Integer productId, Integer brandId);
}
