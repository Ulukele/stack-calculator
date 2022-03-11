package Calculator.Exceptions;

public class CalculatorOperationException extends CalculatorException {
    public CalculatorOperationException() { super(); }

    public CalculatorOperationException(String message) {
        super(message);
    }
}
