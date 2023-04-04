package aquinones.technicaltest.techincaltest.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PricesPk implements Serializable {
    private Integer brandId;
    private Integer productId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    // Constructores, getters y setters

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PricesPk that = (PricesPk) o;

        if (!brandId.equals(that.brandId)) return false;
        if (!productId.equals(that.productId)) return false;
        if (!startDate.equals(that.startDate)) return false;
        return endDate.equals(that.endDate);
    }

    @Override
    public int hashCode() {
        int result = brandId.hashCode();
        result = 31 * result + productId.hashCode();
        result = 31 * result + startDate.hashCode();
        result = 31 * result + endDate.hashCode();
        return result;
    }
}
