package by.kapitonov.computer.shop.backend.exception;

import lombok.extern.log4j.Log4j;

@Log4j
public class ProductDetailsNotFoundException extends RuntimeException {

    public ProductDetailsNotFoundException() {
        super();
    }

    public ProductDetailsNotFoundException(String message) {
        super(message);
        log.error(message);
    }

    public ProductDetailsNotFoundException(String message, Throwable cause) {
        super(message, cause);
        log.error(message, cause);
    }

    public ProductDetailsNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ProductDetailsNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        log.error(message, cause);
    }
}
