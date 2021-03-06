package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.SecretQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecretQuestionRepository extends JpaRepository<SecretQuestion, Long> {

    Optional<SecretQuestion> findBySecretQuestionName(String question);

}
