package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.product.HardDisk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HardDiskRepository extends JpaRepository<HardDisk, Long> {

    Optional<HardDisk> findByProduct_ProductName(String productName);

}
