package Calculator.Operators;

import Calculator.Exceptions.CalculatorStackSizeException;
import Calculator.ExecutionContext;

import java.util.Stack;

public class Print extends OperatorWithoutArgs {
    public Print() {}

    @Override
    public void execute(ExecutionContext executionContext) throws CalculatorStackSizeException {
        Stack<Double> stack = executionContext.getStack();
        if (stack.isEmpty()) {
            throw new CalculatorStackSizeException(stack, 1);
        } else {
            System.out.println(stack.peek());
        }
    }
}
