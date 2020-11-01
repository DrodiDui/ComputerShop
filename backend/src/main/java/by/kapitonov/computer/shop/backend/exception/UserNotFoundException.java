package by.kapitonov.computer.shop.backend.exception;

import lombok.extern.log4j.Log4j;

@Log4j
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super();
    }

    public UserNotFoundException(String message) {
        super(message);
        log.error(message);
    }

    public UserNotFoundException(String message, Throwable cause) {
        super(message, cause);
        log.error(message, cause);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause);
    }

    protected UserNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        log.error(message, cause);
    }
}
