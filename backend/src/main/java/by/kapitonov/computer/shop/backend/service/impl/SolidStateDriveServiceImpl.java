package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.ProductNotFoundException;
import by.kapitonov.computer.shop.backend.model.product.Product;
import by.kapitonov.computer.shop.backend.model.product.SolidStateDrive;
import by.kapitonov.computer.shop.backend.repository.SolidStateDriveRepository;
import by.kapitonov.computer.shop.backend.service.ProductService;
import by.kapitonov.computer.shop.backend.service.SolidStateDriveService;
import by.kapitonov.computer.shop.backend.service.dto.ProductDTO;
import by.kapitonov.computer.shop.backend.service.dto.SolidStateDriveDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SolidStateDriveServiceImpl implements SolidStateDriveService {

    private final SolidStateDriveRepository driveRepository;
    private final ProductService productService;

    public SolidStateDriveServiceImpl(SolidStateDriveRepository driveRepository,
                                      ProductService productService) {
        this.driveRepository = driveRepository;
        this.productService = productService;
    }

    @Override
    public Page<SolidStateDrive> getAll(Pageable pageable) {
        Page<SolidStateDrive> solidStateDrivePage = driveRepository.findAll(pageable);

        if (!solidStateDrivePage.hasContent()) {
            throw new ProductNotFoundException("Solid state drive haven't been found");
        }

        return solidStateDrivePage;
    }

    @Override
    public SolidStateDrive getByProductName(String productName) {
        return driveRepository.findByProduct_ProductName(productName)
                .orElseThrow(
                        () -> new ProductNotFoundException("Solid state drive han't been found")
                );
    }

    @Override
    public SolidStateDrive create(SolidStateDriveDTO solidStateDriveDTO) {
        SolidStateDrive solidStateDrive = SolidStateDrive.builder()
                .size(solidStateDriveDTO.getSize())
                .product(getProduct(solidStateDriveDTO.getProductDTO()))
                .build();
        return driveRepository.save(solidStateDrive);
    }

    private Product getProduct(ProductDTO productDTO) {
        return productService.create(productDTO);
    }
}
