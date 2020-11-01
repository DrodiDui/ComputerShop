package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.product.detail.MotherboardFormFactor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MotherboardFormFactorRepository extends JpaRepository<MotherboardFormFactor, Long> {

    Optional<MotherboardFormFactor> findByProduct_ProductName(String formFactorName);

    boolean existsByFormFactorName(String formFactorName);

}
