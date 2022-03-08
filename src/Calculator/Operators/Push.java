package Calculator.Operators;

import Calculator.ExecutionContext;
import Common.CalculatorToken;

public class Push extends OperatorWithArgs {
    public Push() {}

    @Override
    public void execute(ExecutionContext executionContext) throws UnsupportedOperationException {
        if (args.size() != 1) {
            throw new UnsupportedOperationException("Expect 1 argument, got " + args.size());
        }
//        if ()
        CalculatorToken token = args.get(0);
        Double value;
        if (token.isIdentifier()) {
            String identifier = token.toString();
            value = executionContext.getVariables().get(identifier);
            if (value == null) throw new UnsupportedOperationException("There is no such variable " + identifier);
        }
        else {
            value = token.toDouble();
        }
        executionContext.getStack().push(value);
    }
}
