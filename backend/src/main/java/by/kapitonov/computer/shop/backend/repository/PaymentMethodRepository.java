package by.kapitonov.computer.shop.backend.repository;

import by.kapitonov.computer.shop.backend.model.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {

    Optional<PaymentMethod> findByPaymentName(String paymentName);

}
