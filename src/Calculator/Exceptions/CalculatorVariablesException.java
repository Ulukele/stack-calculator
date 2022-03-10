package Calculator.Exceptions;

public class CalculatorVariablesException extends CalculatorExecutionContextException {
    public CalculatorVariablesException() { super(); }

    public CalculatorVariablesException(String message) {
        super(message);
    }
}
