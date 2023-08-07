package es.inditex.commerce.mapper;

import es.inditex.commerce.dbo.Prices;
import es.inditex.commerce.dto.PricesDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PricesMapper {

    PricesMapper INSTANCE = Mappers.getMapper(PricesMapper.class);

    @Mapping(target = "productId", source = "prices.productId")
    @Mapping(target = "brandId", source = "prices.brandId")
    @Mapping(target = "priceList", source = "prices.priceList")
    @Mapping(target = "startDate", source = "prices.startDate")
    @Mapping(target = "endDate", source = "prices.endDate")
    @Mapping(target = "price", source = "prices.price")
    PricesDto toPricesDto(Prices prices);

}
