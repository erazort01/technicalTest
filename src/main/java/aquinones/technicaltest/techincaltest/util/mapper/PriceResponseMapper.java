package aquinones.technicaltest.techincaltest.util.mapper;

import aquinones.technicaltest.techincaltest.entity.Prices;
import aquinones.technicaltest.techincaltest.model.PriceResponse;
import aquinones.technicaltest.techincaltest.util.Utils;

public class PriceResponseMapper {
    
    public static PriceResponse mapPriceToPriceResponse(Prices price){
        PriceResponse response = new PriceResponse();
        response.setBrandId(price.getPricesPK().getBrandId());
        response.setProductId(price.getPricesPK().getProductId());
        response.setPrice(price.getPrice());
        response.setPriceList(price.getPriceList());
        response.setPriority(price.getPriority());
        response.setCurr(price.getCurr());
        response.setStartDate(Utils.convertLocalDateTimeToString(price.getPricesPK().getStartDate()));
        response.setEndDate(Utils.convertLocalDateTimeToString(price.getPricesPK().getEndDate()));
        return response;
    }
}
