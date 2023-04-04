package aquinones.technicaltest.techincaltest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PriceResponse {
    private Integer brandId;
    private String startDate;
    private String endDate;
    private Integer priceList;
    private Integer productId;
    private Integer priority;
    private float price;
    private String curr;
}
