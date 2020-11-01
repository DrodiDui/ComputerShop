package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.product.detail.PowerSupplyCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PowerSupplyCategoryRepository extends JpaRepository<PowerSupplyCategory, Long> {

    Optional<PowerSupplyCategory> findByCategoryName(String categoryName);

    boolean existsByCategoryName(String categoryName);

}
