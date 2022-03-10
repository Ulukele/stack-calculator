package Calculator.Operators;

import Calculator.Exceptions.CalculatorStackSizeException;
import Calculator.ExecutionContext;

import java.util.Stack;

public class Print extends OperatorWithoutArgs {
    private String output = null;
    public Print() {}

    @Override
    public void execute(ExecutionContext executionContext) throws CalculatorStackSizeException {
        Stack<Double> stack = executionContext.getStack();
        if (stack.isEmpty()) {
            throw new CalculatorStackSizeException(stack, 1);
        } else {
            output = stack.peek().toString();
        }
    }

    @Override
    public String getOutput() {
        return output;
    }
}
