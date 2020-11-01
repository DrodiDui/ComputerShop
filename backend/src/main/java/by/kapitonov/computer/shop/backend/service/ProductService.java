package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.product.Product;
import by.kapitonov.computer.shop.backend.service.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {

    Page<Product> getAllByCategory(String category, Pageable pageable);

    Product getOneByNameAndCategory(String category, String productName);
    Product getOneById(Long id);


    Product create(ProductDTO productDTO);

}
