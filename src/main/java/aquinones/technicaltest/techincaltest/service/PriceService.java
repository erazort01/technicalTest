package aquinones.technicaltest.techincaltest.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import aquinones.technicaltest.techincaltest.entity.Prices;
import aquinones.technicaltest.techincaltest.model.PriceRequest;
import aquinones.technicaltest.techincaltest.model.PriceResponse;
import aquinones.technicaltest.techincaltest.repository.PriceRepository;
import aquinones.technicaltest.techincaltest.util.mapper.PriceResponseMapper;

@Service
public class PriceService {
    
    @Autowired
    private PriceRepository priceRepository;

    public PriceResponse getPriceByParams(PriceRequest request) {

        List<Prices> prices = priceRepository.findByBrandIdAndProductIdAndApplicationDate(request.getBrandId(), request.getProductId(), request.getApplicationDate());

        if (prices.isEmpty()) return null;

        Prices result = prices.stream()
        .max(Comparator.comparing(Prices::getPriority))
        .get();

        PriceResponse response = PriceResponseMapper.mapPriceToPriceResponse(result);

        return response;

    }
}
