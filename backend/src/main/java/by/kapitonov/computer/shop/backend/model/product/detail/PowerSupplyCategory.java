package by.kapitonov.computer.shop.backend.model.product.detail;

import by.kapitonov.computer.shop.backend.model.AuditEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "power_supply_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PowerSupplyCategory extends AuditEntity {

    @Column(name = "category_name", nullable = false, length = 50)
    private String categoryName;


}
