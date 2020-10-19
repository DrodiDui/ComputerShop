package by.kapitonov.computer.shop.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductStatusNotFoundException extends RuntimeException {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductStatusNotFoundException.class);

    public ProductStatusNotFoundException() {
        super();
    }

    public ProductStatusNotFoundException(String message) {
        super(message);
        LOGGER.error(message);
    }

    public ProductStatusNotFoundException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.error(message, cause);
    }

    public ProductStatusNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ProductStatusNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        LOGGER.error(message, cause);
    }
}
