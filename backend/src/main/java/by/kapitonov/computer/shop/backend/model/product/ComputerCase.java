package by.kapitonov.computer.shop.backend.model.product;

import by.kapitonov.computer.shop.backend.model.AuditEntity;
import by.kapitonov.computer.shop.backend.model.product.detail.ComputerCaseType;
import by.kapitonov.computer.shop.backend.model.product.detail.MotherboardFormFactor;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "computer_cases")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@EntityListeners(AuditingEntityListener.class)
public class ComputerCase extends AuditEntity {

    @Column(name = "color", nullable = false, length = 50)
    private String color;

    @Column(name = "window_material", nullable = false, length = 50)
    private String windowMaterial;

    @Column(name = "width", nullable = false)
    private Integer width;

    @Column(name = "depth", nullable = false)
    private Integer depth;

    @Column(name = "height", nullable = false)
    private Integer height;

    @Column(name = "weight", nullable = false)
    private Integer weight;

    @OneToOne
    @JoinColumn(name = "computer_case_type_id", referencedColumnName = "id")
    private ComputerCaseType computerCaseType;

    @OneToOne
    @JoinColumn(name = "max_motherboard_size_id", referencedColumnName = "id")
    private MotherboardFormFactor motherboardFormFactor;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

}