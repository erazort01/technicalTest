package aquinones.technicaltest.techincaltest.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import aquinones.technicaltest.techincaltest.entity.Prices;
import aquinones.technicaltest.techincaltest.entity.PricesPk;

public interface PriceRepository extends JpaRepository<Prices, PricesPk>{
    
    @Query("SELECT p FROM Prices p WHERE p.pricesPK.brandId = :brandId AND p.pricesPK.productId = :productId AND (p.pricesPK.startDate <= :applicationDate AND p.pricesPK.endDate >= :applicationDate)")
    List<Prices> findByBrandIdAndProductIdAndApplicationDate(@Param("brandId") Integer brandId, @Param("productId") Integer productId, @Param("applicationDate") LocalDateTime applicationDate);   
}
