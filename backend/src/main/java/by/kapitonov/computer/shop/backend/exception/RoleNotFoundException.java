package by.kapitonov.computer.shop.backend.exception;

import lombok.extern.log4j.Log4j;

@Log4j
public class RoleNotFoundException extends RuntimeException {

    public RoleNotFoundException() {
        super();
    }

    public RoleNotFoundException(String message) {
        super(message);
        log.error(message);
    }

    public RoleNotFoundException(String message, Throwable cause) {
        super(message, cause);
        log.error(message, cause);
    }

    public RoleNotFoundException(Throwable cause) {
        super(cause);
    }

    protected RoleNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        log.error(message, cause);
    }
}
