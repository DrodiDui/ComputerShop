package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.ProductDetailsAlreadyExists;
import by.kapitonov.computer.shop.backend.exception.ProductDetailsNotFoundException;
import by.kapitonov.computer.shop.backend.model.product.detail.ProductStatus;
import by.kapitonov.computer.shop.backend.repository.ProductStatusRepository;
import by.kapitonov.computer.shop.backend.service.ProductStatusService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
            throw new ProductDetailsNotFoundException("Product statuses haven't been found");
        }

        return productStatuses;
    }

    @Override
    public List<String> getAllProductStatsNames() {

        List<String> productStatusNames = statusRepository.findAll()
                .stream()
                .map(ProductStatus::getStatusName)
                .collect(Collectors.toList());

        if (productStatusNames.isEmpty()) {
            throw new ProductDetailsNotFoundException("Product stats names haven't been found");
        }

        return productStatusNames;
    }

    @Override
    public ProductStatus getByStatusName(String statusName) {
        return statusRepository.findByStatusName(statusName)
                .orElseThrow(
                        () -> new ProductDetailsNotFoundException("Product status hasn't been found")
                );
    }

    @Override
    public ProductStatus create(String statusName) {
        if (statusRepository.existsByStatusName(statusName)) {
            throw new ProductDetailsAlreadyExists("Product status already exists");
        }
        return statusRepository.save(new ProductStatus(statusName));
    }
}
