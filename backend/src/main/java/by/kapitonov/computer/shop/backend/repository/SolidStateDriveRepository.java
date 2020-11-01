package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.product.SolidStateDrive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SolidStateDriveRepository extends JpaRepository<SolidStateDrive, Long> {

    Optional<SolidStateDrive> findByProduct_ProductName(String productName);

}
