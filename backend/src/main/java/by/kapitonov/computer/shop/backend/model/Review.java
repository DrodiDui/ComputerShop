package by.kapitonov.computer.shop.backend.model;

import by.kapitonov.computer.shop.backend.model.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Table(name = "reviews")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Review extends AuditEntity {

    @Column(name = "message", nullable = false, length = 255)
    private String message;

    @Column(name = "advantages", nullable = false, length = 255)
    private String advantages;

    @Column(name = "disadvantages", nullable = false, length = 255)
    private String disadvantages;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @JsonIgnore
    private Product product;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

}
