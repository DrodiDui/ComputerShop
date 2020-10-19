package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.Order;
import by.kapitonov.computer.shop.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByUser(User user);

}
