package Calculator.Operators;

import Calculator.Exceptions.CalculationException;
import Calculator.Exceptions.CalculatorStackSizeException;
import Calculator.ExecutionContext;

import java.util.Stack;

public class Sqrt extends OperatorWithoutArgs {
    public Sqrt() {}

    @Override
    public void execute(ExecutionContext executionContext) throws CalculatorStackSizeException, CalculationException {
        Stack<Double> stack = executionContext.getStack();
        if (stack.isEmpty()) {
            throw new CalculatorStackSizeException(stack, 1);
        }
        Double value = stack.pop();
        Double result = Math.sqrt(value);
        if (result.isInfinite() || result.isNaN()) {
            throw new CalculationException("Exception in SQRT ", value);
        }
        stack.push(result);
    }
}
