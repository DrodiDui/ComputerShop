package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.OrderStatusAlreadyExists;
import by.kapitonov.computer.shop.backend.exception.OrderStatusNotFoundException;
import by.kapitonov.computer.shop.backend.model.OrderStatus;
import by.kapitonov.computer.shop.backend.repository.OrderStatusRepository;
import by.kapitonov.computer.shop.backend.service.OrderStatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {

    private final OrderStatusRepository orderStatusRepository;

    public OrderStatusServiceImpl(OrderStatusRepository orderStatusRepository) {
        this.orderStatusRepository = orderStatusRepository;
    }

    @Override
    public List<OrderStatus> getAll() {
        List<OrderStatus> orderStatuses = orderStatusRepository.findAll();

        if (orderStatuses.isEmpty()) {
            throw new OrderStatusNotFoundException("Orders hasn't been found");
        }
        return null;
    }

    @Override
    public OrderStatus create(String status) {
        if (orderStatusRepository.existsByStatusName(status)) {
            throw new OrderStatusAlreadyExists("Order status already exists");
        }

        return orderStatusRepository.save(new OrderStatus(status));
    }
}
