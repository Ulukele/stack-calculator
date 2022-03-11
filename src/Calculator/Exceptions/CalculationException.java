package Calculator.Exceptions;

public class CalculationException extends CalculatorException {
    public CalculationException() { super(); }
    public CalculationException(String message) {
        super(message);
    }

    public CalculationException(String message, Double value) {
        super(message + " with value " + value);
    }

    public CalculationException(String message, Double first, Double second) {
        super(message + " between values " + first + " and " + second);
    }
}
