package by.kapitonov.computer.shop.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProductCategoryNotFoundException extends RuntimeException {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCategoryNotFoundException.class);

    public ProductCategoryNotFoundException() {
        super();
    }

    public ProductCategoryNotFoundException(String message) {
        super(message);
        LOGGER.error(message);
    }

    public ProductCategoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.error(message, cause);
    }

    public ProductCategoryNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ProductCategoryNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        LOGGER.error(message, cause);
    }
}
