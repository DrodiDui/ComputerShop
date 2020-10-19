package by.kapitonov.computer.shop.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReviewNotFoundException extends RuntimeException {
    private static final Logger LOGGER = LoggerFactory.getLogger(ReviewNotFoundException.class);

    public ReviewNotFoundException() {
        super();
    }

    public ReviewNotFoundException(String message) {
        super(message);
        LOGGER.error(message);
    }

    public ReviewNotFoundException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.error(message, cause);
    }

    public ReviewNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ReviewNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        LOGGER.error(message, cause);
    }
}
