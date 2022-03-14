package Calculator;

import Calculator.Common.CalculatorOperation;
import Calculator.Exceptions.*;
import Calculator.Operators.CalculatorOperatorInterface;
import Calculator.OperatorsFactory.OperatorsFactory;

import java.util.logging.Logger;


public class OperatorsExecutor {
    private final ExecutionContext executionContext;
    private final OperatorsFactory operatorsFactory;
    private final Logger logger = Logger.getLogger(OperatorsExecutor.class.getName());

    public OperatorsExecutor() {
        operatorsFactory = new OperatorsFactory();
        executionContext = new ExecutionContext();
    }

    public void executeOne(CalculatorOperatorInterface operator) throws CalculatorException {
        operator.execute(executionContext);
        String output = operator.getOutput();
        if (output != null) {
            logger.info("Output: " + output);
        }
    }

    public void executeOperation(CalculatorOperation calculatorOperation) throws CalculatorException, FactoryException {
        CalculatorOperatorInterface operator = operatorsFactory.getInstance(calculatorOperation.getOperatorName());
        operator.passArgs(calculatorOperation.getArgs());
        executeOne(operator);
    }
}
