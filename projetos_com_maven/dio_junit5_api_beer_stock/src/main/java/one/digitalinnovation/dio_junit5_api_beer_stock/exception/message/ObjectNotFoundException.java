package one.digitalinnovation.dio_junit5_api_beer_stock.exception.message;

import net.bytebuddy.implementation.bytecode.Throw;

public class ObjectNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ObjectNotFoundException(String msg) {
        super(msg);
    }
    public ObjectNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
