package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.product.detail.ComputerCaseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComputerCaseTypeRepository extends JpaRepository<ComputerCaseType, Long> {

    Optional<ComputerCaseType> findByCaseTypeName(String caseTypeName);

    boolean existsByCaseTypeName(String caseTypeName);

}
