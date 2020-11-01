package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.product.Ram;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RamRepository extends JpaRepository<Ram, Long> {

    Optional<Ram> findByProduct_ProductName(String productName);

}
