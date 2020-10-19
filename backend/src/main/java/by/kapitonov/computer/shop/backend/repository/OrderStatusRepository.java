package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {

    Optional<OrderStatus> findByStatusName(String statusName);

    boolean existsByStatusName(String statusName);

}
