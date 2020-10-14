package by.kapitonov.computer.shop.backend.model;


import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;

@Table(name = "secret_questions")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@EntityListeners(AuditingEntityListener.class)
public class SecretQuestion extends AuditEntity {

    @Column(name = "secret_question_name", nullable = false, length = 100)
    private String secretQuestionName;

}
