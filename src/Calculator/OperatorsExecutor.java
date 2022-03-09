package Calculator;

import Calculator.Exceptions.CalculationException;
import Calculator.Exceptions.CalculatorExecutionContextException;
import Calculator.Exceptions.OperatorArgsInterpretException;
import Calculator.Exceptions.OperatorException;
import Calculator.Operators.CalculatorOperatorInterface;

public class OperatorsExecutor {
    private final ExecutionContext executionContext;

    public OperatorsExecutor() {
        executionContext = new ExecutionContext();
    }

    public void executeOne(CalculatorOperatorInterface operator)
            throws OperatorException, CalculatorExecutionContextException, CalculationException {
        operator.execute(executionContext);
    }
}
