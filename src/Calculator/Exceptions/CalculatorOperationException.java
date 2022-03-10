package Calculator.Exceptions;

public class CalculatorOperationException extends Exception {
    public CalculatorOperationException() { super(); }

    public CalculatorOperationException(String message) {
        super(message);
    }
}
