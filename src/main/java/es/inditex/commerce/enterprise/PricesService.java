package es.inditex.commerce.enterprise;

import es.inditex.commerce.bussines.PricesTemplate;
import es.inditex.commerce.dto.PricesDto;
import es.inditex.commerce.mapper.PricesMapper;
import es.inditex.commerce.repository.PricesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PricesService implements PricesTemplate {

    private static final PricesMapper MAPPER = PricesMapper.INSTANCE;

    private final PricesRepository pricesRepository;

    @Override
    public List<PricesDto> findRateByProduct(LocalDateTime startDate, Integer productId, Integer brandId) {
        return pricesRepository.findByStartDateGreaterThanEqualAndProductIdAndBrandId(startDate, productId, brandId)
                .stream()
                .map(MAPPER::toPricesDto)
                .collect(Collectors.toList());
    }

}
