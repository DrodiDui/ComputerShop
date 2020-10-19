package by.kapitonov.computer.shop.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderStatusNotFoundException extends RuntimeException {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderStatusNotFoundException.class);

    public OrderStatusNotFoundException() {
        super();
    }

    public OrderStatusNotFoundException(String message) {
        super(message);
        LOGGER.error(message);
    }

    public OrderStatusNotFoundException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.error(message, cause);
    }

    public OrderStatusNotFoundException(Throwable cause) {
        super(cause);
    }

    protected OrderStatusNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        LOGGER.error(message, cause);
    }
}
