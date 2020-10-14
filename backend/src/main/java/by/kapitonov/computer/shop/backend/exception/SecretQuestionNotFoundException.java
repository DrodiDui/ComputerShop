package by.kapitonov.computer.shop.backend.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecretQuestionNotFoundException extends RuntimeException {
    private static final Logger LOGGER = LoggerFactory.getLogger(SecretQuestionNotFoundException.class);

    public SecretQuestionNotFoundException() {
        super();
    }

    public SecretQuestionNotFoundException(String message) {
        super(message);
        LOGGER.error(message);
    }

    public SecretQuestionNotFoundException(String message, Throwable cause) {
        super(message, cause);
        LOGGER.error(message, cause);
    }

    public SecretQuestionNotFoundException(Throwable cause) {
        super(cause);
    }

    protected SecretQuestionNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        LOGGER.error(message, cause);
    }
}
