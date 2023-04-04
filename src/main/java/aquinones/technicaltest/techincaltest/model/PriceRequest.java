package aquinones.technicaltest.techincaltest.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PriceRequest {

    private Integer productId;

    private Integer brandId;

    private LocalDateTime applicationDate;
}
