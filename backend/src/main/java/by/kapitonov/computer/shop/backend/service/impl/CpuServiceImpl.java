package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.ProductNotFoundException;
import by.kapitonov.computer.shop.backend.model.product.Cpu;
import by.kapitonov.computer.shop.backend.model.product.Product;
import by.kapitonov.computer.shop.backend.model.product.detail.Socket;
import by.kapitonov.computer.shop.backend.repository.CpuRepository;
import by.kapitonov.computer.shop.backend.service.CpuService;
import by.kapitonov.computer.shop.backend.service.ProductService;
import by.kapitonov.computer.shop.backend.service.SocketService;
import by.kapitonov.computer.shop.backend.service.dto.CpuDTO;
import by.kapitonov.computer.shop.backend.service.dto.ProductDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CpuServiceImpl implements CpuService {

    private final CpuRepository cpuRepository;
    private final ProductService productService;
    private final SocketService socketService;

    public CpuServiceImpl(CpuRepository cpuRepository,
                          ProductService productService,
                          SocketService socketService) {
        this.cpuRepository = cpuRepository;
        this.productService = productService;
        this.socketService = socketService;
    }

    @Override
    public Page<Cpu> getAll(Pageable pageable) {
        Page<Cpu> cpus = cpuRepository.findAll(pageable);

        if (!cpus.hasContent()) {
            throw new ProductNotFoundException("Cpus haven't been found");
        }

        return cpus;
    }

    @Override
    public Cpu getByProductName(String productName) {
        return cpuRepository.findByProduct_ProductName(productName)
                .orElseThrow(
                        () -> new ProductNotFoundException("Product hasn't been found")
                );
    }

    @Override
    public Cpu create(CpuDTO cpuDTO) {
        Cpu cpu = Cpu.builder()
                .countOfCore(cpuDTO.getCountOfCore())
                .maxCountOfThread(cpuDTO.getMaxCountOfThread())
                .clockFrequency(cpuDTO.getClockFrequency())
                .maxClockFrequency(cpuDTO.getMaxClockFrequency())
                .technicalProcess(cpuDTO.getTechnicalProcess())
                .socket(getSocket(cpuDTO.getSocket()))
                .product(getProduct(cpuDTO.getProductDTO()))
                .build();
        return cpuRepository.save(cpu);
    }

    private Socket getSocket(String socketName) {
        return socketService.getSocketByName(socketName);
    }

    private Product getProduct(ProductDTO productDTO) {
        return productService.create(productDTO);
    }
}
