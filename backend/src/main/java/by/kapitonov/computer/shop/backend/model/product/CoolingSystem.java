package by.kapitonov.computer.shop.backend.model.product;

import by.kapitonov.computer.shop.backend.model.AuditEntity;
import by.kapitonov.computer.shop.backend.model.product.detail.Socket;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "cooling_systems")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@EntityListeners(AuditingEntityListener.class)
public class CoolingSystem extends AuditEntity {

    @Column(name = "power_dissipation", nullable = false)
    private Integer powerDissipation;

    @Column(name = "radiator_material", nullable = false, length = 50)
    private String radiatorMaterial;

    @Column(name = "number_of_heat_pipes", nullable = false)
    private Integer numberOfHeatPipes;

    @Column(name = "fan_diameter", nullable = false)
    private Integer fanDiameter;

    @Column(name = "count_of_fan", nullable = false)
    private Integer countOfFan;

    @Column(name = "max_rotation_speed", nullable = false)
    private Integer maxRotationSpeed;

    @Column(name = "backlight", nullable = false)
    private Boolean backlight;

    @OneToOne
    @JoinColumn(name = "socket_id", referencedColumnName = "id")
    private Socket socket;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

}
