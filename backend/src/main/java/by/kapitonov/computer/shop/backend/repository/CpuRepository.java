package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.product.Cpu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CpuRepository extends JpaRepository<Cpu, Long> {

    Optional<Cpu> findByProduct_ProductName(String productName);
}
