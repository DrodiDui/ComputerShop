package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.ProductCategory;

import java.util.List;

public interface ProductCategoryService {

    List<ProductCategory> getAll();
    ProductCategory create(String categoryName);

}
