package by.kapitonov.computer.shop.backend.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "product_statuses")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ProductStatus extends AuditEntity {

    @Column(name = "status_name", nullable = false, length = 50)
    private String statusName;

}
