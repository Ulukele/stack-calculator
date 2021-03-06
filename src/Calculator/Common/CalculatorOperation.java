package Calculator.Common;

import Calculator.Exceptions.CalculatorOperationException;

import java.util.List;

/**
 * Value class for line of code
 * contains:
 * - operator name
 * - args for that operator
 * throws if list is empty or null
 */
public class CalculatorOperation {
    private final String operatorName;
    private final List<CalculatorToken> args;

    public CalculatorOperation(List<CalculatorToken> tokensLine) throws CalculatorOperationException {
        if (tokensLine == null || tokensLine.size() == 0) {
            throw new CalculatorOperationException("Expect non empty tokens list, got " + tokensLine);
        }
        operatorName = tokensLine.get(0).toString();
        args = tokensLine.subList(1, tokensLine.size());
    }

    public String getOperatorName() {
        return operatorName;
    }

    public List<CalculatorToken> getArgs() {
        return args;
    }
}
