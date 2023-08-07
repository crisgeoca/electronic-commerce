package es.inditex.commerce.repository;

import es.inditex.commerce.dbo.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PricesRepository extends JpaRepository<Prices, Integer> {

    List<Prices> findByStartDateGreaterThanEqualAndProductIdAndBrandId(LocalDateTime startDate, Integer productId, Integer brandId);

}
