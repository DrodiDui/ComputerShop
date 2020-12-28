package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.ProductNotFoundException;
import by.kapitonov.computer.shop.backend.model.product.Product;
import by.kapitonov.computer.shop.backend.model.product.detail.ProductCategory;
import by.kapitonov.computer.shop.backend.model.product.detail.ProductStatus;
import by.kapitonov.computer.shop.backend.repository.ProductRepository;
import by.kapitonov.computer.shop.backend.service.ImageService;
import by.kapitonov.computer.shop.backend.service.ProductCategoryService;
import by.kapitonov.computer.shop.backend.service.ProductService;
import by.kapitonov.computer.shop.backend.service.ProductStatusService;
import by.kapitonov.computer.shop.backend.service.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductStatusService productStatusService;
    private final ProductCategoryService productCategoryService;
    private final ImageService imageService;

    public ProductServiceImpl(ProductRepository productRepository,
                              ProductStatusService productStatusService,
                              ProductCategoryService productCategoryService,
                              ImageService imageService) {
        this.productRepository = productRepository;
        this.productStatusService = productStatusService;
        this.productCategoryService = productCategoryService;
        this.imageService = imageService;
    }

    @Override
    public Page<Product> getAllByCategory(String category, Pageable pageable) {
        Page<Product> products = productRepository.findAllByProductCategory(category, pageable);

        if (!products.hasContent()) {
            throw new ProductNotFoundException("Products haven't been found");
        }

        return products;
    }

    @Override
    public List<Product> getAllProductByName(String productName) {
        List<Product> products =  productRepository.findAllByProductNameContains(productName);

        if (products.isEmpty()) {
            throw new ProductNotFoundException("Products haven't been found");
        }

        return products;
    }

    @Override
    public List<Product> getAllProductsByIds(List<Long> ids) {
        List<Product> products = productRepository.findAllById(ids);

        if (products.isEmpty()) {
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
    public Product getOneById(Long id) {
        return productRepository.findById(id)
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
                .previewImage(imageService.create(productDTO.getPreviewImage()))
                .build();

        return productRepository.save(product);
    }

    private ProductCategory getProductCategory(String productCategory) {
        return productCategoryService.getByCategoryName(productCategory);
    }

    private ProductStatus getProductStatus(String productStatus) {
        return productStatusService.getByStatusName(productStatus);
    }
}
