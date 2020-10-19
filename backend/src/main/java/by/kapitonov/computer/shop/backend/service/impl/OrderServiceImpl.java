package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.OrderNotFoundException;
import by.kapitonov.computer.shop.backend.exception.UserNotFoundException;
import by.kapitonov.computer.shop.backend.model.Order;
import by.kapitonov.computer.shop.backend.model.OrderStatus;
import by.kapitonov.computer.shop.backend.model.Product;
import by.kapitonov.computer.shop.backend.model.User;
import by.kapitonov.computer.shop.backend.repository.OrderRepository;
import by.kapitonov.computer.shop.backend.repository.OrderStatusRepository;
import by.kapitonov.computer.shop.backend.repository.UserRepository;
import by.kapitonov.computer.shop.backend.service.OrderService;
import by.kapitonov.computer.shop.backend.service.ProductService;
import by.kapitonov.computer.shop.backend.service.dto.OrderDTO;
import by.kapitonov.computer.shop.backend.util.SecurityUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderStatusRepository orderStatusRepository;
    private final UserRepository userRepository;
    private final ProductService productService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderStatusRepository orderStatusRepository,
                            UserRepository userRepository,
                            ProductService productService) {
        this.orderRepository = orderRepository;
        this.orderStatusRepository = orderStatusRepository;
        this.userRepository = userRepository;
        this.productService = productService;
    }

    @Override
    public List<Order> getAllOrdersForCurrentUser() {
        List<Order> orders = orderRepository.findByUser(getCurrentUser());

        if (orders.isEmpty()) {
            throw new OrderNotFoundException();
        }

        return orders;
    }

    @Override
    public Order getOneOrder(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(
                        () -> new OrderNotFoundException("Order hasn't been found")
                );
    }

    @Override
    public Order create(OrderDTO orderDTO) {

        Order order = Order.builder()
                .orderStatus(getOrderStatus(orderDTO.getOrderStatus()))
                .product(getProducts(orderDTO.getProductId()))
                .user(getCurrentUser())
                .build();

        return orderRepository.save(order);
    }


    private OrderStatus getOrderStatus(String status) {
        return orderStatusRepository.findByStatusName(status)
                .orElseThrow(
                        () -> new OrderNotFoundException("Order status hasn't been found")
                );
    }

    private User getCurrentUser() {
        return userRepository.findById(SecurityUtil.getUserId())
                .orElseThrow(
                        () -> new UserNotFoundException("User hasn't been found")
                );
    }

    private List<Product> getProducts(List<Long> productId) {
        List<Product> products = new ArrayList<>();
        for (int i = 0; i < productId.size(); i++) {
            products.add(productService.getOneById(productId.get(i)));
        }
        return products;
    }

}
