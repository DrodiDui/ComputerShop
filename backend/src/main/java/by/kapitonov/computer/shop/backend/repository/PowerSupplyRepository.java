package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.product.PowerSupply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PowerSupplyRepository extends JpaRepository<PowerSupply, Long> {

    Optional<PowerSupply> findByProduct_ProductName(String productName);

}
