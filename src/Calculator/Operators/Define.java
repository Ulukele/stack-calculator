package Calculator.Operators;

import Calculator.ExecutionContext;
import Common.CalculatorToken;

public class Define extends OperatorWithArgs {
    public Define() {}

    @Override
    public void execute(ExecutionContext executionContext) throws UnsupportedOperationException {
        if (args.size() == 2) {
            CalculatorToken identifier = args.get(0);
            if (!identifier.isIdentifier()) {
                throw new UnsupportedOperationException("Expect variable name, got " + identifier);
            }
            Double value = args.get(1).toDouble();
            executionContext.getVariables().put(identifier.toString(), value);
        } else {
            throw new UnsupportedOperationException("Expect 1 argument, got " + args.size());
        }
    }
}
