package by.kapitonov.computer.shop.backend.model.product;

import by.kapitonov.computer.shop.backend.model.AuditEntity;
import by.kapitonov.computer.shop.backend.model.product.detail.PowerSupplyCategory;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "power_supplies")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@EntityListeners(AuditingEntityListener.class)
public class PowerSupply extends AuditEntity {

    @Column(name = "power", nullable = false)
    private Integer power;

    @Column(name = "certificate", nullable = false, length = 50)
    private String certificate;

    @Column(name = "module_power_cable_connection", nullable = false)
    private Boolean modulePowerCableConnection;

    @Column(name = "width", nullable = false)
    private Integer width;

    @Column(name = "depth", nullable = false)
    private Integer depth;

    @Column(name = "height", nullable = false)
    private Integer height;

    @OneToOne
    @JoinColumn(name = "power_supply_category_id", referencedColumnName = "id")
    private PowerSupplyCategory powerSupplyCategory;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

}
