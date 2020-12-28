package by.kapitonov.computer.shop.backend.model;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Customer extends AuditEntity {

    @Column(name = "first_name", nullable = true, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = true, length = 50)
    private String lastName;

    @Column(name = "cell_phone", nullable = true, length = 15)
    private String cellPhone;

    @Embedded
    @Nullable
    private Address address;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "gender_id", referencedColumnName = "id")
    private Gender gender;

}
