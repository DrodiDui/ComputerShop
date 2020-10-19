package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.ProductCategoryNotFoundException;
import by.kapitonov.computer.shop.backend.exception.ProductNotFoundException;
import by.kapitonov.computer.shop.backend.exception.ProductStatusNotFoundException;
import by.kapitonov.computer.shop.backend.model.Product;
import by.kapitonov.computer.shop.backend.model.ProductCategory;
import by.kapitonov.computer.shop.backend.model.ProductStatus;
import by.kapitonov.computer.shop.backend.repository.ProductCategoryRepository;
import by.kapitonov.computer.shop.backend.repository.ProductRepository;
import by.kapitonov.computer.shop.backend.repository.ProductStatusRepository;
import by.kapitonov.computer.shop.backend.service.ProductService;
import by.kapitonov.computer.shop.backend.service.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductStatusRepository productStatusRepository;
    private final ProductCategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              ProductStatusRepository productStatusRepository,
                              ProductCategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.productStatusRepository = productStatusRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<Product> getAllByCategory(String category, Pageable pageable) {
        Page<Product> products = productRepository.findAllByProductCategory(category, pageable);

        if (products.getContent().isEmpty()) {
            throw new ProductNotFoundException("Products haven't been found");
        }

        return products;
    }

    @Override
    public Product getOneByNameAndCategory(String category, String productName) {
        return productRepository.findByProductNameAndProductCategory(category, productName)
                .orElseThrow(
                        () -> new ProductNotFoundException("Product hasn't been found")
                );
    }

    @Override
    public Product create(ProductDTO productDTO) {
        Product product = Product.builder()
                .productName(productDTO.getProductName())
                .description(productDTO.getDescription())
                .price(productDTO.getPrice())
                .model(productDTO.getModel())
                .brand(productDTO.getBrand())
                .ageOfRelease(productDTO.getAgeOfRelease())
                .countInStock(productDTO.getCountInStock())
                .productCategory(getProductCategory(productDTO.getProductCategory()))
                .productStatus(getProductStatus(productDTO.getProductStatus()))
                .build();

        return productRepository.save(product);
    }

    private ProductCategory getProductCategory(String productCategory) {
        return categoryRepository.findByCategoryName(productCategory)
                .orElseThrow(
                        () -> new ProductCategoryNotFoundException()
                );
    }

    private ProductStatus getProductStatus(String productStatus) {
        return productStatusRepository.findByStatusName(productStatus)
                .orElseThrow(
                        () -> new ProductStatusNotFoundException("Product status hasn't been found")
                );
    }
}
