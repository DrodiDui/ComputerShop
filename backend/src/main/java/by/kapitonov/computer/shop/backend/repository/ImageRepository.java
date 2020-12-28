package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
