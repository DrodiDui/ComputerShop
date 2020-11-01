package by.kapitonov.computer.shop.backend.exception;

import lombok.extern.log4j.Log4j;

@Log4j
public class OrderStatusAlreadyExists extends RuntimeException {

    public OrderStatusAlreadyExists() {
        super();
    }

    public OrderStatusAlreadyExists(String message) {
        super(message);
        log.error(message);
    }

    public OrderStatusAlreadyExists(String message, Throwable cause) {
        super(message, cause);
        log.error(message, cause);
    }

    public OrderStatusAlreadyExists(Throwable cause) {
        super(cause);
    }

    protected OrderStatusAlreadyExists(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        log.error(message, cause);
    }


}
