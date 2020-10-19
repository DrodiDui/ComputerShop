package by.kapitonov.computer.shop.backend.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "product_categories")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ProductCategory extends AuditEntity {

    @Column(name = "category_name", nullable = false, length = 50)
    private String categoryName;

}
