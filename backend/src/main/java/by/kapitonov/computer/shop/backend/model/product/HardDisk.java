package by.kapitonov.computer.shop.backend.model.product;

import by.kapitonov.computer.shop.backend.model.AuditEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "hard_disks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@EntityListeners(AuditingEntityListener.class)
public class HardDisk extends AuditEntity {

    @Column(name = "disk_size", nullable = false)
    private Integer diskSize;

    @Column(name = "spindle_speed", nullable = false)
    private Integer spindleSpeed;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

}
