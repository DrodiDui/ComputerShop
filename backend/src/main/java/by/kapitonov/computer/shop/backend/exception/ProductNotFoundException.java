package by.kapitonov.computer.shop.backend.exception;

import lombok.extern.log4j.Log4j;

@Log4j
public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        super();
    }

    public ProductNotFoundException(String message) {
        super(message);
        log.error(message);
    }

    public ProductNotFoundException(String message, Throwable cause) {
        super(message, cause);
        log.error(message, cause);
    }

    public ProductNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ProductNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        log.error(message, cause);
    }
}
