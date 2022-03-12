package Calculator;

import Calculator.Exceptions.CalculationException;
import Calculator.Exceptions.CalculatorExecutionContextException;
import Calculator.Exceptions.OperatorException;
import Calculator.Operators.CalculatorOperatorInterface;

import java.util.logging.Logger;


public class OperatorsExecutor {
    private final ExecutionContext executionContext;
    private final Logger logger = Logger.getLogger(OperatorsExecutor.class.getName());

    public OperatorsExecutor() {
        executionContext = new ExecutionContext();
    }

    public void executeOne(CalculatorOperatorInterface operator)
            throws OperatorException, CalculatorExecutionContextException, CalculationException {
        operator.execute(executionContext);
        String output = operator.getOutput();
        if (output != null) {
            logger.info("Output: " + output);
        }
    }
}
