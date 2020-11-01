package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.ProductNotFoundException;
import by.kapitonov.computer.shop.backend.model.product.HardDisk;
import by.kapitonov.computer.shop.backend.model.product.Product;
import by.kapitonov.computer.shop.backend.repository.HardDiskRepository;
import by.kapitonov.computer.shop.backend.service.HardDiskService;
import by.kapitonov.computer.shop.backend.service.ProductService;
import by.kapitonov.computer.shop.backend.service.dto.HardDiskDto;
import by.kapitonov.computer.shop.backend.service.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class HardDiskServiceImpl implements HardDiskService {

    private final HardDiskRepository hardDiskRepository;
    private final ProductService productService;

    public HardDiskServiceImpl(HardDiskRepository hardDiskRepository,
                               ProductService productService) {
        this.hardDiskRepository = hardDiskRepository;
        this.productService = productService;
    }

    @Override
    public Page<HardDisk> getAll(Pageable pageable) {
        Page<HardDisk> hardDisks = hardDiskRepository.findAll(pageable);

        if (!hardDisks.hasContent()) {
            throw new ProductNotFoundException("Hard disks haven't been found");
        }

        return hardDisks;
    }

    @Override
    public HardDisk getByProductName(String productName) {
        return hardDiskRepository.findByProduct_ProductName(productName)
                .orElseThrow(
                        () -> new ProductNotFoundException("Hard disk hasn't been found")
                );
    }

    @Override
    public HardDisk create(HardDiskDto hardDiskDto) {
        HardDisk hardDisk = HardDisk.builder()
                .diskSize(hardDiskDto.getDiskSize())
                .spindleSpeed(hardDiskDto.getSpindleSpeed())
                .product(getProduct(hardDiskDto.getProductDTO()))
                .build();
        return hardDiskRepository.save(hardDisk);
    }

    private Product getProduct(ProductDTO productDTO) {
        return productService.create(productDTO);
    }

}
