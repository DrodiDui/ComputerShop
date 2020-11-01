package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.product.ComputerCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ComputerCaseRepository extends JpaRepository<ComputerCase, Long> {

    Optional<ComputerCase> findByProduct_ProductName(String caseName);

}
