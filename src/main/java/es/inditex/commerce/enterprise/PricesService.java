package es.inditex.commerce.enterprise;

import es.inditex.commerce.bussines.PricesTemplate;
import es.inditex.commerce.dbo.Prices;
import es.inditex.commerce.dto.PricesDto;
import es.inditex.commerce.exception.NotRecordFoundException;
import es.inditex.commerce.mapper.PricesMapper;
import es.inditex.commerce.repository.PricesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;

@Service
@Slf4j
@RequiredArgsConstructor
public class PricesService implements PricesTemplate {

    private static final PricesMapper MAPPER = PricesMapper.INSTANCE;
    public static final String NOT_RECORDS_FOUND = "Not records found";

    private final PricesRepository pricesRepository;

    @Override
    public PricesDto findRateByProduct(LocalDateTime startDate, Integer productId, Integer brandId) {
        return pricesRepository.findByStartDateGreaterThanEqualAndProductIdAndBrandId(startDate, productId, brandId)
                .stream()
                .max(Comparator.comparing(Prices::getPriority) //Some cases will have equal disambiguating priority value
                        .thenComparing(Prices::getPrice))//For those cases will also filter by highest price
                .map(MAPPER::toPricesDto)
                .orElseThrow(() -> new NotRecordFoundException(NOT_RECORDS_FOUND));
    }

}
