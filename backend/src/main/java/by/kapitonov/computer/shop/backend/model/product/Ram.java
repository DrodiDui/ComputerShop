package by.kapitonov.computer.shop.backend.model.product;

import by.kapitonov.computer.shop.backend.model.AuditEntity;
import by.kapitonov.computer.shop.backend.model.product.detail.RamMemoryType;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "rams")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Ram extends AuditEntity {

    @Column(name = "size", nullable = false)
    private Integer size;

    @Column(name = "frequency", nullable = false)
    private Integer frequency;

    @Column(name = "cooling", nullable = false)
    private Boolean cooling;

    @Column(name = "backlight", nullable = false)
    private Boolean backlight;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @OneToOne
    @JoinColumn(name = "memory_type_id", referencedColumnName = "id")
    private RamMemoryType ramMemoryType;

}