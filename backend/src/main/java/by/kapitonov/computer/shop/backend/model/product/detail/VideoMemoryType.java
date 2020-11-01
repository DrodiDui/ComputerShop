package by.kapitonov.computer.shop.backend.model.product.detail;

import by.kapitonov.computer.shop.backend.model.AuditEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "video_memory_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class VideoMemoryType extends AuditEntity{

    @Column(name = "memory_type_name", nullable = false, length = 50)
    private String memoryTypeName;

}
