package by.kapitonov.computer.shop.backend.exception;

import lombok.extern.log4j.Log4j;

@Log4j
public class OrderNotFoundException extends RuntimeException {

    public OrderNotFoundException() {
        super();
    }

    public OrderNotFoundException(String message) {
        super(message);
        log.error(message);
    }

    public OrderNotFoundException(String message, Throwable cause) {
        super(message, cause);
        log.error(message, cause);
    }

    public OrderNotFoundException(Throwable cause) {
        super(cause);
    }

    protected OrderNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        log.error(message, cause);
    }
}
