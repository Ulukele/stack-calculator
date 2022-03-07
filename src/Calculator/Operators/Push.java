package Calculator.Operators;

import Calculator.ExecutionContext;
import Common.CalculatorToken;

import java.util.List;

public class Push implements CalculatorOperator {
    private final List<CalculatorToken> args;

    public Push(List<CalculatorToken> args) {
        this.args = args;
    }

    @Override
    public void execute(ExecutionContext executionContext) throws UnsupportedOperationException {
        if (args.size() == 1) {
            Double value = args.get(0).toDouble();
            executionContext.getStack().push(value);
        } else {
            throw new UnsupportedOperationException("Expect 1 argument, got " + args.size());
        }
    }
}
