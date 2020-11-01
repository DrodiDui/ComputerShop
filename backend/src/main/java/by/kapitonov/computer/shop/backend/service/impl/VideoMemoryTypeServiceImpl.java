package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.ProductDetailsAlreadyExists;
import by.kapitonov.computer.shop.backend.exception.ProductDetailsNotFoundException;
import by.kapitonov.computer.shop.backend.model.product.detail.VideoMemoryType;
import by.kapitonov.computer.shop.backend.repository.VideoMemoryTypeRepository;
import by.kapitonov.computer.shop.backend.service.VideoMemoryTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoMemoryTypeServiceImpl implements VideoMemoryTypeService {

    private final VideoMemoryTypeRepository videoMemoryTypeRepository;

    public VideoMemoryTypeServiceImpl(VideoMemoryTypeRepository videoMemoryTypeRepository) {
        this.videoMemoryTypeRepository = videoMemoryTypeRepository;
    }

    @Override
    public List<VideoMemoryType> getAll() {
        List<VideoMemoryType> videoMemoryTypes = videoMemoryTypeRepository.findAll();

        if (videoMemoryTypes.isEmpty()) {
            throw new ProductDetailsNotFoundException("Video memory types hasn't been found");
        }

        return videoMemoryTypes;
    }

    @Override
    public VideoMemoryType findByTypeName(String typeName) {
        return videoMemoryTypeRepository.findByMemoryTypeName(typeName)
                .orElseThrow(
                        () -> new ProductDetailsNotFoundException("Video memory type hasn't been found")
                );
    }

    @Override
    public VideoMemoryType create(String typeName) {
        if (videoMemoryTypeRepository.existsByMemoryTypeName(typeName)) {
            throw new ProductDetailsAlreadyExists("Video memory type already exists");
        }
        return videoMemoryTypeRepository.save(new VideoMemoryType(typeName));
    }
}
