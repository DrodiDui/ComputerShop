package by.kapitonov.computer.shop.backend.exception;

import lombok.extern.log4j.Log4j;

@Log4j
public class PaymentMethodNotFoundException extends RuntimeException {

    public PaymentMethodNotFoundException() {
        super();
    }

    public PaymentMethodNotFoundException(String message) {
        super(message);
        log.error(message);
    }

    public PaymentMethodNotFoundException(String message, Throwable cause) {
        super(message, cause);
        log.error(message, cause);
    }

    public PaymentMethodNotFoundException(Throwable cause) {
        super(cause);
    }

    protected PaymentMethodNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        log.error(message, cause);
    }
}
