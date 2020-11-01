package by.kapitonov.computer.shop.backend.model.product;

import by.kapitonov.computer.shop.backend.model.AuditEntity;
import by.kapitonov.computer.shop.backend.model.product.detail.VideoMemoryType;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "video_cards")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@EntityListeners(AuditingEntityListener.class)
public class VideoCard extends AuditEntity {

    @Column(name = "video_memory", nullable = false)
    private Integer videoMemory;

    @Column(name = "frequency", nullable = false)
    private Integer frequency;

    @Column(name = "max_frequency")
    private Integer maxFrequency;

    @Column(name = "memory_bus_width", nullable = false)
    private Integer memoryBusWidth;

    @OneToOne
    @JoinColumn(name = "video_memory_type_id", referencedColumnName = "id")
    private VideoMemoryType videoMemoryType;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

}