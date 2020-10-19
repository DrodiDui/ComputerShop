package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.ProductStatusNotFoundException;
import by.kapitonov.computer.shop.backend.model.ProductStatus;
import by.kapitonov.computer.shop.backend.repository.ProductStatusRepository;
import by.kapitonov.computer.shop.backend.service.ProductStatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductStatusServiceImpl implements ProductStatusService {

    private final ProductStatusRepository statusRepository;

    public ProductStatusServiceImpl(ProductStatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }

    @Override
    public List<ProductStatus> getAll() {
        List<ProductStatus> productStatuses = statusRepository.findAll();

        if (productStatuses.isEmpty()) {
            throw new ProductStatusNotFoundException("Product statuses haven't been found");
        }

        return productStatuses;
    }

    @Override
    public ProductStatus create(String statusName) {
        return statusRepository.save(new ProductStatus(statusName));
    }
}
