package by.kapitonov.computer.shop.backend.model.product.detail;

import by.kapitonov.computer.shop.backend.model.AuditEntity;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

@Table(name = "product_statuses")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
public class ProductStatus extends AuditEntity {

    @Column(name = "status_name", nullable = false, length = 50)
    private String statusName;

}
