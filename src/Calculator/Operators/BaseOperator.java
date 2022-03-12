package Calculator.Operators;

import Calculator.ExecutionContext;

import java.util.logging.Logger;

public abstract class BaseOperator implements CalculatorOperatorInterface {
    protected final Logger logger = Logger.getLogger(this.getClass().getName());
    @Override
    public String getOutput() {
        return null;
    }
}
