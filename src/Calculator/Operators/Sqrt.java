package Calculator.Operators;

import Calculator.ExecutionContext;

import java.util.Stack;

public class Sqrt extends OperatorWithoutArgs {
    public Sqrt() {}

    @Override
    public void execute(ExecutionContext executionContext) throws UnsupportedOperationException {
        Stack<Double> stack = executionContext.getStack();
        if (stack.size() != 1) {
            throw new UnsupportedOperationException("Expect at least 1 value in stack, got " + stack.size());
        }
        stack.push(Math.sqrt(stack.pop()));
    }
}
