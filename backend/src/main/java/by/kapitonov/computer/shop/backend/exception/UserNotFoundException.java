package by.kapitonov.computer.shop.backend.exception;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

public class UserNotFoundException extends RuntimeException {
    private static final Logger LOGGER = Logger.getLogger(UserNotFoundException.class);

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
        LOGGER.error(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.error(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    protected UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        LOGGER.error(message, cause);
    }
}
