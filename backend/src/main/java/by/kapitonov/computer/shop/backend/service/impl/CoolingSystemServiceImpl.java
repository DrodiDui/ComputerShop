package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.ProductNotFoundException;
import by.kapitonov.computer.shop.backend.model.product.CoolingSystem;
import by.kapitonov.computer.shop.backend.model.product.Product;
import by.kapitonov.computer.shop.backend.model.product.detail.Socket;
import by.kapitonov.computer.shop.backend.repository.CoolingSystemRepository;
import by.kapitonov.computer.shop.backend.service.CoolingSystemService;
import by.kapitonov.computer.shop.backend.service.ProductService;
import by.kapitonov.computer.shop.backend.service.SocketService;
import by.kapitonov.computer.shop.backend.service.dto.CoolingSystemDTO;
import by.kapitonov.computer.shop.backend.service.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CoolingSystemServiceImpl implements CoolingSystemService {

    private final CoolingSystemRepository coolingSystemRepository;
    private final ProductService productService;
    private final SocketService socketService;

    public CoolingSystemServiceImpl(CoolingSystemRepository coolingSystemRepository,
                                    ProductService productService,
                                    SocketService socketService) {
        this.coolingSystemRepository = coolingSystemRepository;
        this.productService = productService;
        this.socketService = socketService;
    }

    @Override
    public Page<CoolingSystem> getAll(Pageable pageable) {
        Page<CoolingSystem> coolingSystems = coolingSystemRepository.findAll(pageable);

        if (!coolingSystems.hasContent()) {
            throw new ProductNotFoundException("Cooling systems haven't been found");
        }

        return coolingSystems;
    }

    @Override
    public CoolingSystem getByProductName(String productName) {
        return coolingSystemRepository.findByProduct_ProductName(productName)
                .orElseThrow(
                        () -> new ProductNotFoundException("Cooling system hasn't been found")
                );
    }

    @Override
    public CoolingSystem create(CoolingSystemDTO coolingSystemDTO) {
        CoolingSystem coolingSystem = CoolingSystem.builder()
                .backlight(coolingSystemDTO.getBacklight())
                .countOfFan(coolingSystemDTO.getCountOfFan())
                .fanDiameter(coolingSystemDTO.getFanDiameter())
                .maxRotationSpeed(coolingSystemDTO.getMaxRotationSpeed())
                .numberOfHeatPipes(coolingSystemDTO.getNumberOfHeatPipes())
                .powerDissipation(coolingSystemDTO.getPowerDissipation())
                .radiatorMaterial(coolingSystemDTO.getRadiatorMaterial())
                .product(getProduct(coolingSystemDTO.getProductDTO()))
                .socket(getSocket(coolingSystemDTO.getSocket()))
                .build();
        return coolingSystemRepository.save(coolingSystem);
    }

    private Product getProduct(ProductDTO productDTO) {
        return productService.create(productDTO);
    }

    private Socket getSocket(String socketName) {
        return socketService.getSocketByName(socketName);
    }
}
