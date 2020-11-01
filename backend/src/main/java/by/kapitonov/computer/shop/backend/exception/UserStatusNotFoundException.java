package by.kapitonov.computer.shop.backend.exception;

import lombok.extern.log4j.Log4j;

@Log4j
public class UserStatusNotFoundException extends RuntimeException {

    public UserStatusNotFoundException() {
        super();
    }

    public UserStatusNotFoundException(String message) {
        super(message);
        log.error(message);
    }

    public UserStatusNotFoundException(String message, Throwable cause) {
        super(message, cause);
        log.error(message, cause);
    }

    public UserStatusNotFoundException(Throwable cause) {
        super(cause);
    }

    protected UserStatusNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        log.error(message, cause);
    }
}
