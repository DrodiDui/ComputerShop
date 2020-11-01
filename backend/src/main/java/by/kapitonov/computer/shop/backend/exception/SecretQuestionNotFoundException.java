package by.kapitonov.computer.shop.backend.exception;

import lombok.extern.log4j.Log4j;

@Log4j
public class SecretQuestionNotFoundException extends RuntimeException {

    public SecretQuestionNotFoundException() {
        super();
    }

    public SecretQuestionNotFoundException(String message) {
        super(message);
        log.error(message);
    }

    public SecretQuestionNotFoundException(String message, Throwable cause) {
        super(message, cause);
        log.error(message, cause);
    }

    public SecretQuestionNotFoundException(Throwable cause) {
        super(cause);
    }

    protected SecretQuestionNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        log.error(message, cause);
    }
}
