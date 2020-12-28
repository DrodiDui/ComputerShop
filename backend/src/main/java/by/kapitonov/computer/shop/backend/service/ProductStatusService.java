package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.product.detail.ProductStatus;

import java.util.List;

public interface ProductStatusService {

    List<ProductStatus> getAll();
    List<String> getAllProductStatsNames();

    ProductStatus getByStatusName(String statusName);

    ProductStatus create(String statusName);

}
