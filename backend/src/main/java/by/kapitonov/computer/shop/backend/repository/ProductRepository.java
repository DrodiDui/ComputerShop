package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findAllByProductCategory(String productCategory, Pageable pageable);

    /*@Query("select p from Product as p left join fetch Review as r on r.product.id = p.id where p.productName = :productName")*/
    Optional<Product> findByProductNameAndProductCategory(String productCategory, String productName);

}
