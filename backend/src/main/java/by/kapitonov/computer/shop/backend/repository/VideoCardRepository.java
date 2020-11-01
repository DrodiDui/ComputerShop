package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.product.VideoCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VideoCardRepository extends JpaRepository<VideoCard, Long> {

    Optional<VideoCard> findByProduct_ProductName(String productName);

}
