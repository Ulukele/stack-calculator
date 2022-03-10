package Calculator.Exceptions;

public class CalculatorExecutionContextException extends Exception {
    public CalculatorExecutionContextException() { super(); }

    public CalculatorExecutionContextException(String message) {
        super(message);
    }
}
