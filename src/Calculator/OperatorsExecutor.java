package Calculator;

import Calculator.Operators.CalculatorOperatorInterface;

public class OperatorsExecutor {
    private final ExecutionContext executionContext;

    public OperatorsExecutor() {
        executionContext = new ExecutionContext();
    }

    public void executeOne(CalculatorOperatorInterface operator) throws UnsupportedOperationException {
        operator.execute(executionContext);
    }
}
