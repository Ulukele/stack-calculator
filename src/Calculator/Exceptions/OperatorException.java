package Calculator.Exceptions;

public class OperatorException extends CalculatorException {
    public OperatorException() { super(); }

    public OperatorException(String message) {
        super(message);
    }
}
