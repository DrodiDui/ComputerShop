package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.OrderStatusAlreadyExists;
import by.kapitonov.computer.shop.backend.exception.OrderStatusNotFoundException;
import by.kapitonov.computer.shop.backend.model.OrderStatus;
import by.kapitonov.computer.shop.backend.repository.OrderStatusRepository;
import by.kapitonov.computer.shop.backend.service.OrderStatusService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<String> getAllOrderStatusNames() {
        List<String> orderStatusNames = orderStatusRepository.findAll()
                .stream()
                .map(OrderStatus::getStatusName)
                .collect(Collectors.toList());

        if (orderStatusNames.isEmpty()) {
            throw new OrderStatusNotFoundException("Order status names haven't been found");
        }

        return orderStatusNames;
    }

    @Override
    public OrderStatus create(String status) {
        if (orderStatusRepository.existsByStatusName(status)) {
            throw new OrderStatusAlreadyExists("Order status already exists");
        }

        return orderStatusRepository.save(new OrderStatus(status));
    }
}
