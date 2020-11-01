package by.kapitonov.computer.shop.backend.exception;

import lombok.extern.log4j.Log4j;

@Log4j
public class ProductDetailsAlreadyExists extends RuntimeException {

    public ProductDetailsAlreadyExists() {
        super();
    }

    public ProductDetailsAlreadyExists(String message) {
        super(message);
        log.error(message);
    }

    public ProductDetailsAlreadyExists(String message, Throwable cause) {
        super(message, cause);
        log.error(message, cause);
    }

    public ProductDetailsAlreadyExists(Throwable cause) {
        super(cause);
    }

    protected ProductDetailsAlreadyExists(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        log.error(message, cause);
    }
}
