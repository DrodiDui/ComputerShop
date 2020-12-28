package by.kapitonov.computer.shop.backend.model;

import by.kapitonov.computer.shop.backend.model.product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Table(name = "orders")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Order extends AuditEntity {

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "order_products",
            joinColumns = {@JoinColumn(name = "order_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")}
    )
    private List<Product> product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_status_id", referencedColumnName = "id")
    private OrderStatus orderStatus;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id", referencedColumnName = "id")
    private PaymentMethod paymentMethod;

}
