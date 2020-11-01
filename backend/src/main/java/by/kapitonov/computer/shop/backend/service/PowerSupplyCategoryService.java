package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.product.detail.PowerSupplyCategory;

import java.util.List;

public interface PowerSupplyCategoryService {

    List<PowerSupplyCategory> getAll();

    PowerSupplyCategory getByCategoryName(String categoryName);

    PowerSupplyCategory create(String categoryName);

}
