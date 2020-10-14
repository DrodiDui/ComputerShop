package by.kapitonov.computer.shop.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserStatusNotFoundException extends RuntimeException {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserStatusNotFoundException.class);

    public UserStatusNotFoundException() {
        super();
    }

    public UserStatusNotFoundException(String message) {
        super(message);
        LOGGER.error(message);
    }

    public UserStatusNotFoundException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.error(message, cause);
    }

    public UserStatusNotFoundException(Throwable cause) {
        super(cause);
    }

    protected UserStatusNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        LOGGER.error(message, cause);
    }
}
