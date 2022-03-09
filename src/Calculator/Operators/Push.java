package Calculator.Operators;

import Calculator.Exceptions.CalculatorVariablesException;
import Calculator.Exceptions.OperatorArgsCountException;
import Calculator.Exceptions.OperatorArgsException;
import Calculator.Exceptions.OperatorArgsInterpretException;
import Calculator.ExecutionContext;
import Calculator.Common.CalculatorToken;

public class Push extends OperatorWithArgs {
    public Push() {}

    @Override
    public void execute(ExecutionContext executionContext) throws OperatorArgsException, CalculatorVariablesException {
        if (args.size() != 1) {
            throw new OperatorArgsCountException(args, 1);
        }
        CalculatorToken token = args.get(0);
        Double value;
        if (token.isIdentifier()) {
            String identifier = token.toString();
            value = executionContext.getVariables().get(identifier);
            if (value == null) throw new CalculatorVariablesException("There is no such variable '" + identifier + "'");
        }
        else {
            value = token.toDouble();
        }
        executionContext.getStack().push(value);
    }
}
