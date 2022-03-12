package Calculator.Operators;

import Calculator.Exceptions.CalculationException;
import Calculator.Exceptions.CalculatorStackSizeException;
import Calculator.ExecutionContext;

import java.util.Stack;

public class Divide extends OperatorWithoutArgs {
    public Divide() {}

    @Override
    public void execute(ExecutionContext executionContext) throws CalculatorStackSizeException, CalculationException {
        Stack<Double> stack = executionContext.getStack();
        if (stack.size() < 2) {
            throw new CalculatorStackSizeException(stack, 2);
        } else {
            Double first = stack.pop();
            Double second = stack.pop();
            Double result = first / second;
            if (result.isInfinite() || result.isNaN()) {
                throw new CalculationException("Problem with dividing ", first, second);
            }
            logger.fine("Result: " + result);
            stack.push(result);
        }
    }
}
