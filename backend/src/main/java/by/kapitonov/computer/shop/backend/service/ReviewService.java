package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.Review;
import by.kapitonov.computer.shop.backend.service.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {

    List<Review> getAllByProduct(Long id);
    Review create(ReviewDTO reviewDTO);

}
