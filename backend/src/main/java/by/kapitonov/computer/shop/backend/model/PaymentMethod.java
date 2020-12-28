package by.kapitonov.computer.shop.backend.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "payment_methods")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class PaymentMethod extends AuditEntity {

    @Column(name = "payment_name", nullable = false, length = 50)
    private String paymentName;
}
