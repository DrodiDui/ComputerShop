package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.OrderStatus;

import java.util.List;

public interface OrderStatusService {

    List<OrderStatus> getAll();
    List<String> getAllOrderStatusNames();
    OrderStatus create(String status);

}
