package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.ProductDetailsAlreadyExists;
import by.kapitonov.computer.shop.backend.exception.ProductDetailsNotFoundException;
import by.kapitonov.computer.shop.backend.model.product.detail.PowerSupplyCategory;
import by.kapitonov.computer.shop.backend.repository.PowerSupplyCategoryRepository;
import by.kapitonov.computer.shop.backend.service.PowerSupplyCategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PowerSupplyCategoryServiceImpl implements PowerSupplyCategoryService {

    private final PowerSupplyCategoryRepository categoryRepository;

    public PowerSupplyCategoryServiceImpl(PowerSupplyCategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<PowerSupplyCategory> getAll() {
        List<PowerSupplyCategory> powerSupplyCategories = categoryRepository.findAll();

        if (powerSupplyCategories.isEmpty()) {
            throw new ProductDetailsNotFoundException("Power supply categories haven't been found");
        }

        return powerSupplyCategories;
    }

    @Override
    public PowerSupplyCategory getByCategoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName)
                .orElseThrow(
                        () -> new ProductDetailsNotFoundException("Power supply category hasn't been found")
                );
    }

    @Override
    public PowerSupplyCategory create(String categoryName) {
        if (categoryRepository.existsByCategoryName(categoryName)) {
            throw new ProductDetailsAlreadyExists("Power supply category already exists");
        }
        return categoryRepository.save(new PowerSupplyCategory(categoryName));
    }
}
