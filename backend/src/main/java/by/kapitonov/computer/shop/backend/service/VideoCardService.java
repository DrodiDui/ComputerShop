package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.product.VideoCard;
import by.kapitonov.computer.shop.backend.service.dto.VideoCardDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VideoCardService {

    Page<VideoCard> getAll(Pageable pageable);

    VideoCard getByProductName(String productName);

    VideoCard create(VideoCardDTO videoCardDTO);

}
