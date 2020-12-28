package by.kapitonov.computer.shop.backend.rest.controller;

import by.kapitonov.computer.shop.backend.service.PaymentMethodService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/payment-methods")
public class PaymentMethodRestController {

    private final PaymentMethodService paymentMethodService;

    public PaymentMethodRestController(PaymentMethodService paymentMethodService) {
        this.paymentMethodService = paymentMethodService;
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllPaymentMethodNames() {

        List<String> paymentNames = paymentMethodService.getAllPaymentMethodNames();

        return new ResponseEntity<>(paymentNames, HttpStatus.OK);
    }
}
