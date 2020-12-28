package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.OrderNotFoundException;
import by.kapitonov.computer.shop.backend.model.Order;
import by.kapitonov.computer.shop.backend.model.OrderStatus;
import by.kapitonov.computer.shop.backend.model.PaymentMethod;
import by.kapitonov.computer.shop.backend.model.User;
import by.kapitonov.computer.shop.backend.model.product.Product;
import by.kapitonov.computer.shop.backend.repository.OrderRepository;
import by.kapitonov.computer.shop.backend.repository.OrderStatusRepository;
import by.kapitonov.computer.shop.backend.repository.ProductRepository;
import by.kapitonov.computer.shop.backend.service.OrderService;
import by.kapitonov.computer.shop.backend.service.PaymentMethodService;
import by.kapitonov.computer.shop.backend.service.ProductService;
import by.kapitonov.computer.shop.backend.service.UserService;
import by.kapitonov.computer.shop.backend.service.dto.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderStatusRepository orderStatusRepository;
    private final UserService userService;
    private final ProductService productService;
    private final ProductRepository productRepository;
    private final PaymentMethodService paymentMethodService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            OrderStatusRepository orderStatusRepository,
                            UserService userService,
                            ProductService productService,
                            ProductRepository productRepository,
                            PaymentMethodService paymentMethodService) {
        this.orderRepository = orderRepository;
        this.orderStatusRepository = orderStatusRepository;
        this.userService = userService;
        this.productService = productService;
        this.productRepository = productRepository;
        this.paymentMethodService = paymentMethodService;
    }

    @Override
    public List<Order> getAllOrdersForCurrentUser(Long id) {
        List<Order> orders = orderRepository.findByUser(getCurrentUser(id));

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
                .orderStatus(getOrderStatus("in stock"))
                .product(getProducts(orderDTO.getProductIds()))
                .user(getCurrentUser(orderDTO.getUserId()))
                .paymentMethod(getPaymentMethod(orderDTO.getPaymentMethod()))
                .build();

        return orderRepository.save(order);
    }

    private OrderStatus getOrderStatus(String status) {
        return orderStatusRepository.findByStatusName(status)
                .orElseThrow(
                        () -> new OrderNotFoundException("Order status hasn't been found")
                );
    }

    private User getCurrentUser(Long id) {
        return userService.getUserById(id);
    }

    private List<Product> getProducts(List<Long> productIds) {
        if (productIds.isEmpty()) {
            return null;
        }
        return productIds
                .stream()
                .map(productId -> {
                    return productService.getOneById(productId);
                })
                .collect(Collectors.toList());
    }

    private PaymentMethod getPaymentMethod(String paymentMethod) {
        return paymentMethodService.getOneByName(paymentMethod);
    }

}
