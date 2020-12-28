package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.product.detail.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> getAll();
    List<String> getAllCategoryNames();

    ProductCategory getByCategoryName(String categoryName);

    ProductCategory create(String categoryName);

}
