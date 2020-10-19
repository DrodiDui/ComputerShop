package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.ProductCategoryNotFoundException;
import by.kapitonov.computer.shop.backend.model.ProductCategory;
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
            throw new ProductCategoryNotFoundException("Products haven't been found");
        }

        return productCategories;
    }

    @Override
    public ProductCategory create(String categoryName) {
        return categoryRepository.save(new ProductCategory(categoryName));
    }
}
