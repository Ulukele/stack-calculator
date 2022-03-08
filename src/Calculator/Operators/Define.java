package Calculator.Operators;

import Calculator.ExecutionContext;
import Common.CalculatorToken;

import java.util.List;

public class Define extends OperatorWithArgs {
    public Define() {}

    @Override
    public void execute(ExecutionContext executionContext) throws UnsupportedOperationException {
        if (args.size() == 2) {
            String name = args.get(0).toString();
            Double value = args.get(1).toDouble();
            executionContext.getVariables().put(name, value);
        } else {
            throw new UnsupportedOperationException("Expect 1 argument, got " + args.size());
        }
    }
}
