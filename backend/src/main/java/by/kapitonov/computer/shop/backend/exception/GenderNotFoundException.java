package by.kapitonov.computer.shop.backend.exception;

import lombok.extern.log4j.Log4j;

@Log4j
public class GenderNotFoundException extends RuntimeException {

    public GenderNotFoundException() {
        super();
    }

    public GenderNotFoundException(String message) {
        super(message);
        log.error(message);
    }

    public GenderNotFoundException(String message, Throwable cause) {
        super(message, cause);
        log.error(message, cause);
    }

    public GenderNotFoundException(Throwable cause) {
        super(cause);
    }

    protected GenderNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        log.error(message, cause);
    }
}
