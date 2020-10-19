package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.Product;
import by.kapitonov.computer.shop.backend.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findAllByProduct(Product product);

}
