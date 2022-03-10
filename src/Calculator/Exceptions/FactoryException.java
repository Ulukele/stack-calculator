package Calculator.Exceptions;

public class FactoryException extends RuntimeException {
    public FactoryException() { super(); }

    public FactoryException(String message) {
        super(message);
    }

    public FactoryException(String message, Throwable cause) {
        super(message, cause);
    }
}
