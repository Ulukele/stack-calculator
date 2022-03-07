package Calculator.Operators;

import Calculator.ExecutionContext;

import java.util.Stack;

public class Divide implements CalculatorOperator {
    public Divide() {}

    @Override
    public void execute(ExecutionContext executionContext) throws UnsupportedOperationException {
        Stack<Double> stack = executionContext.getStack();
        if (stack.size() < 2) {
            throw new UnsupportedOperationException("Expect at least 2 value in stack, got " + stack.size());
        } else {
            Double first = stack.pop();
            Double second = stack.pop();
            double result = first / second;
            if (result == Double.NEGATIVE_INFINITY || result == Double.POSITIVE_INFINITY) {
                throw new UnsupportedOperationException("Divide by zero");
            }
            stack.push(result);
        }
    }
}
