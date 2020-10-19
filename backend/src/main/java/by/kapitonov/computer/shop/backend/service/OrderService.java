package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.Order;
import by.kapitonov.computer.shop.backend.service.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrdersForCurrentUser();
    Order getOneOrder(Long id);
    Order create(OrderDTO orderDTO);


}
