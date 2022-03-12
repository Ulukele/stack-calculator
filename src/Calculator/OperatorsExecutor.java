package Calculator;

import Calculator.Exceptions.CalculationException;
import Calculator.Exceptions.CalculatorExecutionContextException;
import Calculator.Exceptions.OperatorException;
import Calculator.Operators.CalculatorOperatorInterface;
import Logging.EventsLogger;

import java.util.logging.Level;


public class OperatorsExecutor {
    private final ExecutionContext executionContext;

    public OperatorsExecutor() {
        executionContext = new ExecutionContext();
    }

    public void executeOne(CalculatorOperatorInterface operator)
            throws OperatorException, CalculatorExecutionContextException, CalculationException {
        EventsLogger.logp(Level.INFO, operator.getClass().getName(), "execute", "Executing operator");
        operator.execute(executionContext);
        String output = operator.getOutput();
        if (output != null) {
            EventsLogger.log(Level.INFO, output);
        }
    }
}
