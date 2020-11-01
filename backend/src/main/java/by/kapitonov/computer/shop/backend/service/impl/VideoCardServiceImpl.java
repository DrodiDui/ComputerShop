package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.ProductNotFoundException;
import by.kapitonov.computer.shop.backend.model.product.Product;
import by.kapitonov.computer.shop.backend.model.product.VideoCard;
import by.kapitonov.computer.shop.backend.model.product.detail.VideoMemoryType;
import by.kapitonov.computer.shop.backend.repository.VideoCardRepository;
import by.kapitonov.computer.shop.backend.service.ProductService;
import by.kapitonov.computer.shop.backend.service.VideoCardService;
import by.kapitonov.computer.shop.backend.service.VideoMemoryTypeService;
import by.kapitonov.computer.shop.backend.service.dto.ProductDTO;
import by.kapitonov.computer.shop.backend.service.dto.VideoCardDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class VideoCardServiceImpl implements VideoCardService {

    private final VideoCardRepository videoCardRepository;
    private final ProductService productService;
    private final VideoMemoryTypeService videoMemoryTypeService;

    public VideoCardServiceImpl(VideoCardRepository videoCardRepository,
                                ProductService productService,
                                VideoMemoryTypeService videoMemoryTypeService) {
        this.videoCardRepository = videoCardRepository;
        this.productService = productService;
        this.videoMemoryTypeService = videoMemoryTypeService;
    }

    @Override
    public Page<VideoCard> getAll(Pageable pageable) {
        Page<VideoCard> videoCardPage = videoCardRepository.findAll(pageable);

        if (!videoCardPage.hasContent()) {
            throw new ProductNotFoundException("Video cards haven't been found");
        }

        return videoCardPage;
    }

    @Override
    public VideoCard getByProductName(String productName) {
        return videoCardRepository.findByProduct_ProductName(productName)
                .orElseThrow(
                        () -> new ProductNotFoundException("Video card hasn't been found")
                );
    }

    @Override
    public VideoCard create(VideoCardDTO videoCardDTO) {
        VideoCard videoCard = VideoCard.builder()
                .videoMemory(videoCardDTO.getVideoMemory())
                .frequency(videoCardDTO.getFrequency())
                .maxFrequency(videoCardDTO.getMaxFrequency())
                .memoryBusWidth(videoCardDTO.getMemoryBusWidth())
                .videoMemoryType(getVideoMemoryType(videoCardDTO.getVideoMemoryType()))
                .product(getProduct(videoCardDTO.getProductDTO()))
                .build();
        return videoCardRepository.save(videoCard);
    }

    private VideoMemoryType getVideoMemoryType(String memoryTypeName) {
        return videoMemoryTypeService.findByTypeName(memoryTypeName);
    }

    private Product getProduct(ProductDTO productDTO) {
        return productService.create(productDTO);
    }
}
