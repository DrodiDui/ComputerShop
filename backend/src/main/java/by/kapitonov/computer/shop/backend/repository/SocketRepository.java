package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.product.detail.Socket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SocketRepository extends JpaRepository<Socket, Long> {

    Optional<Socket> findBySocketName(String socketName);

    boolean existsBySocketName(String socketName);
}
