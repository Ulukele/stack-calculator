package Calculator.Exceptions;

public class CalculatorExecutionContextException extends CalculatorException {
    public CalculatorExecutionContextException() { super(); }

    public CalculatorExecutionContextException(String message) {
        super(message);
    }
}
