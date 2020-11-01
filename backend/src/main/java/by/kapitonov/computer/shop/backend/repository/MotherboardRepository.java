package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.product.Motherboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MotherboardRepository extends JpaRepository<Motherboard, Long> {

    Optional<Motherboard> findByProduct_ProductName(String productName);

}
