package Calculator.Operators;

import Calculator.Exceptions.*;
import Calculator.ExecutionContext;
import Calculator.Common.CalculatorToken;

public class Define extends OperatorWithArgs {
    public Define() {}

    @Override
    public void execute(ExecutionContext executionContext)
            throws CalculatorExecutionContextException, OperatorArgsException {
        if (args.size() == 2) {
            CalculatorToken identifier = args.get(0);
            if (!identifier.isIdentifier()) {
                throw new CalculatorVariablesException("Expect variable name, got " + identifier);
            }
            Double value = args.get(1).toDouble();
            executionContext.getVariables().put(identifier.toString(), value);
            logger.fine("Defined " + identifier + " as " + value);
        } else {
            throw new OperatorArgsCountException(args, 2);
        }
    }
}
