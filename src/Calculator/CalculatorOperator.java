package Calculator;

import java.util.List;

public interface CalculatorOperator {
    Iterable<OperatorArgument> args = null;
    void execute(ExecutionContext executionContext);
}
