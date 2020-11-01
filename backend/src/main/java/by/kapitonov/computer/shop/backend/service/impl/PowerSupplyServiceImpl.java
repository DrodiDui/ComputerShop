package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.ProductNotFoundException;
import by.kapitonov.computer.shop.backend.model.product.PowerSupply;
import by.kapitonov.computer.shop.backend.model.product.Product;
import by.kapitonov.computer.shop.backend.model.product.detail.PowerSupplyCategory;
import by.kapitonov.computer.shop.backend.repository.PowerSupplyRepository;
import by.kapitonov.computer.shop.backend.service.PowerSupplyCategoryService;
import by.kapitonov.computer.shop.backend.service.PowerSupplyService;
import by.kapitonov.computer.shop.backend.service.ProductService;
import by.kapitonov.computer.shop.backend.service.dto.PowerSupplyDTO;
import by.kapitonov.computer.shop.backend.service.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PowerSupplyServiceImpl implements PowerSupplyService {

    private final PowerSupplyRepository powerSupplyRepository;
    private final PowerSupplyCategoryService powerSupplyCategoryService;
    private final ProductService productService;

    public PowerSupplyServiceImpl(PowerSupplyRepository powerSupplyRepository,
                                  PowerSupplyCategoryService powerSupplyCategoryService,
                                  ProductService productService) {
        this.powerSupplyRepository = powerSupplyRepository;
        this.powerSupplyCategoryService = powerSupplyCategoryService;
        this.productService = productService;
    }

    @Override
    public Page<PowerSupply> getAll(Pageable pageable) {
        Page<PowerSupply> powerSuppliesPage = powerSupplyRepository.findAll(pageable);

        if (!powerSuppliesPage.hasContent()) {
            throw new ProductNotFoundException("Power supplies haven't been found");
        }

        return powerSuppliesPage;
    }

    @Override
    public PowerSupply getByProductName(String productName) {
        return powerSupplyRepository.findByProduct_ProductName(productName)
                .orElseThrow(
                        () -> new ProductNotFoundException("Power supply hasn't been found")
                );
    }

    @Override
    public PowerSupply create(PowerSupplyDTO powerSupplyDTO) {
        PowerSupply powerSupply = PowerSupply.builder()
                .power(powerSupplyDTO.getPower())
                .certificate(powerSupplyDTO.getCertificate())
                .modulePowerCableConnection(powerSupplyDTO.getModulePowerCableConnection())
                .width(powerSupplyDTO.getWidth())
                .height(powerSupplyDTO.getHeight())
                .depth(powerSupplyDTO.getDepth())
                .powerSupplyCategory(getPowerSupplyCategory(powerSupplyDTO.getPowerSupplyCategory()))
                .product(getProduct(powerSupplyDTO.getProductDTO()))
                .build();
        return powerSupplyRepository.save(powerSupply);
    }

    private PowerSupplyCategory getPowerSupplyCategory(String categoryName) {
        return powerSupplyCategoryService.getByCategoryName(categoryName);
    }

    private Product getProduct(ProductDTO productDTO) {
        return productService.create(productDTO);
    }
}
