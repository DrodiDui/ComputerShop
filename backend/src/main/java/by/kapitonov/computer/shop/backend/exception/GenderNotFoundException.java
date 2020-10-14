package by.kapitonov.computer.shop.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GenderNotFoundException extends RuntimeException {
    private static final Logger LOGGER = LoggerFactory.getLogger(GenderNotFoundException.class);

    public GenderNotFoundException() {
        super();
    }

    public GenderNotFoundException(String message) {
        super(message);
        LOGGER.error(message);
    }

    public GenderNotFoundException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.error(message, cause);
    }

    public GenderNotFoundException(Throwable cause) {
        super(cause);
    }

    protected GenderNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        LOGGER.error(message, cause);
    }
}
