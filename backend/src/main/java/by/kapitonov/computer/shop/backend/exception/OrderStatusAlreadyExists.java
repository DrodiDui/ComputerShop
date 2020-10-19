package by.kapitonov.computer.shop.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderStatusAlreadyExists extends RuntimeException {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderStatusAlreadyExists.class);

    public OrderStatusAlreadyExists() {
        super();
    }

    public OrderStatusAlreadyExists(String message) {
        super(message);
        LOGGER.error(message);
    }

    public OrderStatusAlreadyExists(String message, Throwable cause) {
        super(message, cause);
        LOGGER.error(message, cause);
    }

    public OrderStatusAlreadyExists(Throwable cause) {
        super(cause);
    }

    protected OrderStatusAlreadyExists(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        LOGGER.error(message, cause);
    }


}
