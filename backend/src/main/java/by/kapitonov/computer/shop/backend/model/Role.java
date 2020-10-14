package by.kapitonov.computer.shop.backend.model;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

@Table(name = "roles")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@EntityListeners(AuditingEntityListener.class)
public class Role extends AuditEntity {

    @Column(name = "role_name", nullable = false, length = 50)
    private String roleName;

}
