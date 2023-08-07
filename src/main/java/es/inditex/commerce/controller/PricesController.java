package es.inditex.commerce.controller;

import es.inditex.commerce.bussines.PricesTemplate;
import es.inditex.commerce.dto.PricesDto;
import es.inditex.commerce.dto.PricesRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/prices")
@Slf4j
@RequiredArgsConstructor
public class PricesController {

    private final PricesTemplate pricesTemplate;

    @GetMapping("/find-by-query")
    public List<PricesDto> getPricesByQuery(@RequestBody PricesRequestDto pricesRequestDto) {
        return pricesTemplate.findRateByProduct(pricesRequestDto.getStartDate(), pricesRequestDto.getProductId(), pricesRequestDto.getBrandId());
    }

}
