package Calculator.Exceptions;

public class CalculatorStackException extends CalculatorExecutionContextException {
    public CalculatorStackException() { super(); }

    public CalculatorStackException(String message) {
        super(message);
    }
}
