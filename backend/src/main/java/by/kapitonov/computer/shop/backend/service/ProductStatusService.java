package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.ProductStatus;

import java.util.List;

public interface ProductStatusService {

    List<ProductStatus> getAll();
    ProductStatus create(String statusName);

}
