package by.kapitonov.computer.shop.backend.exception;

import lombok.extern.log4j.Log4j;

@Log4j
public class OrderStatusNotFoundException extends RuntimeException {

    public OrderStatusNotFoundException() {
        super();
    }

    public OrderStatusNotFoundException(String message) {
        super(message);
        log.error(message);
    }

    public OrderStatusNotFoundException(String message, Throwable cause) {
        super(message, cause);
        log.error(message, cause);
    }

    public OrderStatusNotFoundException(Throwable cause) {
        super(cause);
    }

    protected OrderStatusNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        log.error(message, cause);
    }
}
