package Calculator.Operators;

import Calculator.ExecutionContext;

import java.util.Stack;

public class Sum extends OperatorWithoutArgs {
    public Sum() {}

    @Override
    public void execute(ExecutionContext executionContext) throws UnsupportedOperationException {
        Stack<Double> stack = executionContext.getStack();
        if (stack.size() < 2) {
            throw new UnsupportedOperationException("Expect at least 2 value in stack, got " + stack.size());
        } else {
            Double first = stack.pop();
            Double second = stack.pop();
            stack.push(first + second);
        }
    }
}
