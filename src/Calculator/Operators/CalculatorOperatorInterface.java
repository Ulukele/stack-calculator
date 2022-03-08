package Calculator.Operators;

import Calculator.ExecutionContext;
import Common.CalculatorToken;

import java.util.List;

public interface CalculatorOperatorInterface {
    void passArgs(List<CalculatorToken> args);
    void execute(ExecutionContext executionContext);
}
