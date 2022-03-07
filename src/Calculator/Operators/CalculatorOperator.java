package Calculator.Operators;

import Calculator.ExecutionContext;
import Common.CalculatorToken;

import java.util.Collection;

public interface CalculatorOperator {
    Collection<CalculatorToken> args = null;
    void execute(ExecutionContext executionContext);
}
