package by.kapitonov.computer.shop.backend.service;

import by.kapitonov.computer.shop.backend.model.PaymentMethod;

import java.util.List;

public interface PaymentMethodService {

    List<String> getAllPaymentMethodNames();

    PaymentMethod getOneByName(String paymentName);

    PaymentMethod create(String paymentName);

}
