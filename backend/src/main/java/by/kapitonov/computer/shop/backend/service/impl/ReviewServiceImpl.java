package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.ProductNotFoundException;
import by.kapitonov.computer.shop.backend.exception.ReviewNotFoundException;
import by.kapitonov.computer.shop.backend.exception.UserNotFoundException;
import by.kapitonov.computer.shop.backend.model.Product;
import by.kapitonov.computer.shop.backend.model.Review;
import by.kapitonov.computer.shop.backend.model.User;
import by.kapitonov.computer.shop.backend.repository.ProductRepository;
import by.kapitonov.computer.shop.backend.repository.ReviewRepository;
import by.kapitonov.computer.shop.backend.repository.UserRepository;
import by.kapitonov.computer.shop.backend.service.ReviewService;
import by.kapitonov.computer.shop.backend.service.dto.ReviewDTO;
import by.kapitonov.computer.shop.backend.util.SecurityUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository,
                             UserRepository userRepository,
                             ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Review> getAllByProduct(Long id) {
        List<Review> reviews = reviewRepository.findAllByProduct(getProduct(id));

        if (reviews.isEmpty()) {
            throw new ReviewNotFoundException("Reviews haven't been found");
        }

        return reviews;
    }

    @Override
    public Review create(ReviewDTO reviewDTO) {
        Review review = Review.builder()
                .message(reviewDTO.getMessage())
                .advantages(reviewDTO.getAdvantages())
                .disadvantages(reviewDTO.getDisadvantages())
                .user(getCurrentUser())
                .product(
                        getProduct(reviewDTO.getProductId())
                )
                .build();
        return reviewRepository.save(review);
    }

    private Product getProduct(Long id) {
        return productRepository.findById(id)
                .orElseThrow(
                        () -> new ProductNotFoundException("Product hasn't been found")
                );
    }

    private User getCurrentUser() {
        return userRepository.findById(SecurityUtil.getUserId())
                .orElseThrow(
                        () -> new UserNotFoundException("User hasn't been found")
                );
    }
}
