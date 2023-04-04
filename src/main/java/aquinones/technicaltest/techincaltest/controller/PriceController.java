package aquinones.technicaltest.techincaltest.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import aquinones.technicaltest.techincaltest.exception.BadRequestException;
import aquinones.technicaltest.techincaltest.model.PriceRequest;
import aquinones.technicaltest.techincaltest.model.PriceResponse;
import aquinones.technicaltest.techincaltest.service.PriceService;
import aquinones.technicaltest.techincaltest.util.Utils;
import aquinones.technicaltest.techincaltest.util.Validator;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api/prices")
public class PriceController {
    
    @Autowired
    private PriceService priceService;

    @GetMapping(produces="application/json")
    public ResponseEntity<?> findPrice(@RequestParam("application_date") String date,
                                       @RequestParam("product_id") Integer productId,
                                       @RequestParam("brand_id") Integer brandId) {

        try {
            Validator.validateStr(date);
            Validator.isValidDateFormat(date);
            
            LocalDateTime applicationDate = Utils.convertStringToLocalDateTime(date);
            PriceRequest request = new PriceRequest(productId, brandId, applicationDate);
            PriceResponse price = priceService.getPriceByParams(request);
            
            if(price != null) 
                return ResponseEntity.ok(price);
            
        } catch (BadRequestException e){
            log.error("Bad request");
            return ResponseEntity.badRequest().build();
        }
 
        return ResponseEntity.notFound().build();

    }

}
