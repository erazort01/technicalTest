package aquinones.technicaltest.techincaltest.entity;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Prices {

    @EmbeddedId
    private PricesPk pricesPK;

    private Integer priceList;
    private Integer priority;
    private float price;
    private String curr;
}
