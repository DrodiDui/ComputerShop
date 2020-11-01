package by.kapitonov.computer.shop.backend.exception;

import lombok.extern.log4j.Log4j;

@Log4j
public class ReviewNotFoundException extends RuntimeException {

    public ReviewNotFoundException() {
        super();
    }

    public ReviewNotFoundException(String message) {
        super(message);
        log.error(message);
    }

    public ReviewNotFoundException(String message, Throwable cause) {
        super(message, cause);
        log.error(message, cause);
    }

    public ReviewNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ReviewNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        log.error(message, cause);
    }
}
