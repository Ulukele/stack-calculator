package Calculator;

import Common.OperatorArgument;

public interface CalculatorOperator {
    Iterable<OperatorArgument> args = null;
    void execute(ExecutionContext executionContext);
}
