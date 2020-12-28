package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByProductCategory(String productCategory, Pageable pageable);

    Optional<Product> findByProductNameAndProductCategory(String productName, String productCategory);

    List<Product> findAllByProductNameContains(String productName);

}
