package Calculator.Operators;

import Calculator.Exceptions.CalculatorStackSizeException;
import Calculator.ExecutionContext;

import java.util.Stack;

public class Pop extends OperatorWithoutArgs {
    public Pop() {}

    @Override
    public void execute(ExecutionContext executionContext) throws CalculatorStackSizeException {
        Stack<Double> stack = executionContext.getStack();
        if (stack.isEmpty()) throw new CalculatorStackSizeException(stack, 1);
        stack.pop();
    }
}
