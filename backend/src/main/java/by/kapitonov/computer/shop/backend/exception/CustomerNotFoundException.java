package by.kapitonov.computer.shop.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerNotFoundException extends RuntimeException {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerNotFoundException.class);

    public CustomerNotFoundException() {
        super();
    }

    public CustomerNotFoundException(String message) {
        super(message);
        LOGGER.error(message);
    }

    public CustomerNotFoundException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.error(message, cause);
    }

    public CustomerNotFoundException(Throwable cause) {
        super(cause);
    }

    protected CustomerNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        LOGGER.error(message, cause);
    }
}
