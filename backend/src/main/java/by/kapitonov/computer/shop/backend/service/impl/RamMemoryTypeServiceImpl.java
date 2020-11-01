package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.ProductDetailsAlreadyExists;
import by.kapitonov.computer.shop.backend.exception.ProductDetailsNotFoundException;
import by.kapitonov.computer.shop.backend.model.product.detail.RamMemoryType;
import by.kapitonov.computer.shop.backend.repository.RamMemoryTypeRepository;
import by.kapitonov.computer.shop.backend.service.RamMemoryTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RamMemoryTypeServiceImpl implements RamMemoryTypeService {

    private final RamMemoryTypeRepository memoryTypeRepository;

    public RamMemoryTypeServiceImpl(RamMemoryTypeRepository memoryTypeRepository) {
        this.memoryTypeRepository = memoryTypeRepository;
    }

    @Override
    public List<RamMemoryType> getAll() {
        List<RamMemoryType> ramMemoryTypes = memoryTypeRepository.findAll();

        if (ramMemoryTypes.isEmpty()) {
            throw new ProductDetailsNotFoundException("Ram memory types haven't been found");
        }

        return ramMemoryTypes;
    }

    @Override
    public RamMemoryType getByMemoryTypeName(String typeName) {
        return memoryTypeRepository.findByTypeName(typeName)
                .orElseThrow(
                        () -> new ProductDetailsNotFoundException("Ram memory type hasn't been found")
                );
    }

    @Override
    public RamMemoryType create(String typeName) {
        if (memoryTypeRepository.existsByTypeName(typeName)) {
            throw new ProductDetailsAlreadyExists("Ram memory type already exists");
        }
        return memoryTypeRepository.save(new RamMemoryType(typeName));
    }
}
