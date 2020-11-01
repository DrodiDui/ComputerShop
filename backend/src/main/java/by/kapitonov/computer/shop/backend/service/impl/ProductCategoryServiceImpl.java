package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.ProductDetailsAlreadyExists;
import by.kapitonov.computer.shop.backend.exception.ProductDetailsNotFoundException;
import by.kapitonov.computer.shop.backend.model.product.detail.ProductCategory;
import by.kapitonov.computer.shop.backend.repository.ProductCategoryRepository;
import by.kapitonov.computer.shop.backend.service.ProductCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository categoryRepository;

    public ProductCategoryServiceImpl(ProductCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<ProductCategory> getAll() {
        List<ProductCategory> productCategories = categoryRepository.findAll();

        if (productCategories.isEmpty()) {
            throw new ProductDetailsNotFoundException("Product categories haven't been found");
        }

        return productCategories;
    }

    @Override
    public ProductCategory getByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName)
                .orElseThrow(
                        () -> new ProductDetailsNotFoundException("Product category hasn't been found")
                );
    }

    @Override
    public ProductCategory create(String categoryName) {
        if (categoryRepository.existsByCategoryName(categoryName)) {
            throw new ProductDetailsAlreadyExists("Product category already exists");
        }
        return categoryRepository.save(new ProductCategory(categoryName));
    }
}
