package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.product.CoolingSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoolingSystemRepository extends JpaRepository<CoolingSystem, Long> {

    Optional<CoolingSystem> findByProduct_ProductName(String productName);

}
