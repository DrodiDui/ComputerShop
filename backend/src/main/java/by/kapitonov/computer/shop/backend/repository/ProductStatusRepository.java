package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.product.detail.ProductStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductStatusRepository extends JpaRepository<ProductStatus, Long> {

    Optional<ProductStatus> findByStatusName(String statusName);

    boolean existsByStatusName(String statusName);
}
