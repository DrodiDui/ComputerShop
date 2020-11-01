package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.product.detail.RamMemoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RamMemoryTypeRepository extends JpaRepository<RamMemoryType, Long> {

    Optional<RamMemoryType> findByTypeName(String typeName);

    boolean existsByTypeName(String typeName);

}
