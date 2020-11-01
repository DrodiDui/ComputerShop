package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.ProductNotFoundException;
import by.kapitonov.computer.shop.backend.model.product.Product;
import by.kapitonov.computer.shop.backend.model.product.Ram;
import by.kapitonov.computer.shop.backend.model.product.detail.RamMemoryType;
import by.kapitonov.computer.shop.backend.repository.RamRepository;
import by.kapitonov.computer.shop.backend.service.ProductService;
import by.kapitonov.computer.shop.backend.service.RamMemoryTypeService;
import by.kapitonov.computer.shop.backend.service.RamService;
import by.kapitonov.computer.shop.backend.service.dto.ProductDTO;
import by.kapitonov.computer.shop.backend.service.dto.RamDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RamServiceImpl implements RamService {

    private final RamRepository ramRepository;
    private final RamMemoryTypeService memoryTypeService;
    private final ProductService productService;

    public RamServiceImpl(RamRepository ramRepository,
                          RamMemoryTypeService memoryTypeService,
                          ProductService productService) {
        this.ramRepository = ramRepository;
        this.memoryTypeService = memoryTypeService;
        this.productService = productService;
    }

    @Override
    public Page<Ram> getAll(Pageable pageable) {
        Page<Ram> ramPage = ramRepository.findAll(pageable);

        if (!ramPage.hasContent()) {
            throw new ProductNotFoundException("Rams haven't been found");
        }

        return ramPage;
    }

    @Override
    public Ram getByProductName(String productName) {
        return ramRepository.findByProduct_ProductName(productName)
                .orElseThrow(
                        () -> new ProductNotFoundException("Ram hasn't been found")
                );
    }

    @Override
    public Ram create(RamDTO ramDTO) {
        Ram ram = Ram.builder()
                .size(ramDTO.getSize())
                .frequency(ramDTO.getFrequency())
                .backlight(ramDTO.getBacklight())
                .cooling(ramDTO.getCooling())
                .ramMemoryType(getMemoryType(ramDTO.getTypeOfMemory()))
                .product(getProduct(ramDTO.getProductDTO()))
                .build();
        return ramRepository.save(ram);
    }

    private RamMemoryType getMemoryType(String typeName) {
        return memoryTypeService.getByMemoryTypeName(typeName);
    }

    private Product getProduct(ProductDTO productDTO) {
        return productService.create(productDTO);
    }
}
