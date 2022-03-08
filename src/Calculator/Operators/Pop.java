package Calculator.Operators;

import Calculator.ExecutionContext;

import java.util.Stack;

public class Pop extends OperatorWithoutArgs {
    public Pop() {}

    @Override
    public void execute(ExecutionContext executionContext) {
        Stack<Double> stack = executionContext.getStack();
        if (stack.isEmpty()) throw new UnsupportedOperationException("Expect at least 1 element in stack, got 0");
        stack.pop();
    }
}
