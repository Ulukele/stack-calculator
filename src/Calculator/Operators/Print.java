package Calculator.Operators;

import Calculator.ExecutionContext;

import java.util.Stack;

public class Print extends OperatorWithoutArgs {
    public Print() {}

    @Override
    public void execute(ExecutionContext executionContext) throws UnsupportedOperationException {
        Stack<Double> stack = executionContext.getStack();
        if (stack.size() < 1) {
            throw new UnsupportedOperationException("Expect at least 1 value in stack, got 0" );
        } else {
            System.console().printf(stack.peek().toString());
        }
    }
}
