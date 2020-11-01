package by.kapitonov.computer.shop.backend.model.product.detail;

import by.kapitonov.computer.shop.backend.model.AuditEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

@Entity
@Table(name = "ram_memory_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@EntityListeners(AuditingEntityListener.class)
public class RamMemoryType extends AuditEntity {

    @Column(name = "memory_type_name", length = 50, nullable = false)
    private String typeName;

}
