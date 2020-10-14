package by.kapitonov.computer.shop.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RoleNotFoundException extends RuntimeException {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleNotFoundException.class);

    public RoleNotFoundException() {
        super();
    }

    public RoleNotFoundException(String message) {
        super(message);
        LOGGER.error(message);
    }

    public RoleNotFoundException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.error(message, cause);
    }

    public RoleNotFoundException(Throwable cause) {
        super(cause);
    }

    protected RoleNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        LOGGER.error(message, cause);
    }
}
