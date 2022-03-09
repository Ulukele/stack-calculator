package Calculator.Exceptions;

import java.util.Stack;

public class CalculatorStackSizeException extends CalculatorStackException {
    public CalculatorStackSizeException(String message) {
        super(message);
    }
    public CalculatorStackSizeException(Stack<?> stack, int requireCount) {
        super("Expect at least " + requireCount + " values in stack, got " + stack.size());
    }
}
