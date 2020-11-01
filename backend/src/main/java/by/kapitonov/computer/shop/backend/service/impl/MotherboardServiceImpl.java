package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.ProductNotFoundException;
import by.kapitonov.computer.shop.backend.model.product.Motherboard;
import by.kapitonov.computer.shop.backend.model.product.Product;
import by.kapitonov.computer.shop.backend.model.product.detail.MotherboardFormFactor;
import by.kapitonov.computer.shop.backend.model.product.detail.RamMemoryType;
import by.kapitonov.computer.shop.backend.model.product.detail.Socket;
import by.kapitonov.computer.shop.backend.repository.MotherboardRepository;
import by.kapitonov.computer.shop.backend.service.*;
import by.kapitonov.computer.shop.backend.service.dto.MotherboardDTO;
import by.kapitonov.computer.shop.backend.service.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MotherboardServiceImpl implements MotherboardService {

    private final MotherboardRepository motherboardRepository;
    private final MotherBoardFormFactorService formFactorService;
    private final SocketService socketService;
    private final RamMemoryTypeService memoryTypeService;
    private final ProductService productService;

    public MotherboardServiceImpl(MotherboardRepository motherboardRepository,
                                  MotherBoardFormFactorService formFactorService,
                                  SocketService socketService,
                                  RamMemoryTypeService memoryTypeService,
                                  ProductService productService) {
        this.motherboardRepository = motherboardRepository;
        this.formFactorService = formFactorService;
        this.socketService = socketService;
        this.memoryTypeService = memoryTypeService;
        this.productService = productService;
    }

    @Override
    public Page<Motherboard> getAll(Pageable pageable) {
        Page<Motherboard> motherboardPage = motherboardRepository.findAll(pageable);

        if (!motherboardPage.hasContent()) {
            throw new ProductNotFoundException("Motherboards haven't been found");
        }

        return motherboardPage;
    }

    @Override
    public Motherboard getByProductName(String motherboardName) {
        return motherboardRepository.findByProduct_ProductName(motherboardName)
                .orElseThrow(
                        () -> new ProductNotFoundException("Motherboard hasn't been found")
                );
    }

    @Override
    public Motherboard create(MotherboardDTO motherboardDTO) {
        Motherboard motherboard = Motherboard.builder()
                .maximumMemoryFrequency(motherboardDTO.getMaximumMemoryFrequency())
                .numberOfMemorySlot(motherboardDTO.getNumberOfMemorySlot())
                .maximumMemorySize(motherboardDTO.getMaximumMemorySize())
                .formFactor(getFormFactor(motherboardDTO.getFormFactor()))
                .socket(getSocket(motherboardDTO.getSocketName()))
                .typeOfMemory(getMemoryType(motherboardDTO.getTypeOfMemory()))
                .product(getProduct(motherboardDTO.getProductDTO()))
                .build();
        return motherboardRepository.save(motherboard);
    }

    private MotherboardFormFactor getFormFactor(String formFactorName) {
        return formFactorService.getByFormFactorName(formFactorName);
    }

    private Socket getSocket(String socketName) {
        return socketService.getSocketByName(socketName);
    }

    private RamMemoryType getMemoryType(String typeName) {
        return memoryTypeService.getByMemoryTypeName(typeName);
    }

    private Product getProduct(ProductDTO productDTO) {
        return productService.create(productDTO);
    }
}
