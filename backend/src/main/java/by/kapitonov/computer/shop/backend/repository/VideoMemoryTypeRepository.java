package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.product.detail.VideoMemoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideoMemoryTypeRepository extends JpaRepository<VideoMemoryType, Long> {

    Optional<VideoMemoryType> findByMemoryTypeName(String typeName);

    boolean existsByMemoryTypeName(String typeName);
}
