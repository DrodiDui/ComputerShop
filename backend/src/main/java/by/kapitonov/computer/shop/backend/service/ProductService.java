package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.product.Product;
import by.kapitonov.computer.shop.backend.service.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {

    Page<Product> getAllByCategory(String category, Pageable pageable);
    List<Product> getAllProductByName(String productName);
    List<Product> getAllProductsByIds(List<Long> ids);

    Product getOneByNameAndCategory(String category, String productName);
    Product getOneById(Long id);


    Product create(ProductDTO productDTO);
}
