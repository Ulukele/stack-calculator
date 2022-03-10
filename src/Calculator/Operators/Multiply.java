package Calculator.Operators;

import Calculator.Exceptions.CalculatorStackSizeException;
import Calculator.ExecutionContext;

import java.util.Stack;

public class Multiply extends OperatorWithoutArgs {
    public Multiply() {}

    @Override
    public void execute(ExecutionContext executionContext) throws CalculatorStackSizeException {
        Stack<Double> stack = executionContext.getStack();
        if (stack.size() < 2) {
            throw new CalculatorStackSizeException(stack, 2);
        } else {
            Double first = stack.pop();
            Double second = stack.pop();
            stack.push(first * second);
        }
    }

    @Override
    public String getOutput() {
        return null;
    }
}
