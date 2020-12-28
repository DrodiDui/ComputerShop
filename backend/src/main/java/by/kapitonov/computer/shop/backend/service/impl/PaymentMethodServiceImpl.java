package by.kapitonov.computer.shop.backend.service.impl;

import by.kapitonov.computer.shop.backend.exception.PaymentMethodNotFoundException;
import by.kapitonov.computer.shop.backend.model.PaymentMethod;
import by.kapitonov.computer.shop.backend.repository.PaymentMethodRepository;
import by.kapitonov.computer.shop.backend.service.PaymentMethodService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;

    public PaymentMethodServiceImpl(PaymentMethodRepository paymentMethodRepository) {
        this.paymentMethodRepository = paymentMethodRepository;
    }

    @Override
    public List<String> getAllPaymentMethodNames() {

        List<String> paymentNames = paymentMethodRepository.findAll()
                .stream()
                .map(PaymentMethod::getPaymentName)
                .collect(Collectors.toList());

        if (paymentNames.isEmpty()) {
            throw new PaymentMethodNotFoundException("Payment method names haven't been found");
        }

        return paymentNames;
    }

    @Override
    public PaymentMethod getOneByName(String paymentName) {
        return paymentMethodRepository.findByPaymentName(paymentName)
                .orElseThrow(
                        () -> new PaymentMethodNotFoundException("Payment method hasn't been found")
                );
    }

    @Override
    public PaymentMethod create(String paymentName) {
        return paymentMethodRepository.save(new PaymentMethod(paymentName));
    }
}
