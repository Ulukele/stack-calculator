package Calculator.Operators;

import Calculator.ExecutionContext;

public class Pop implements CalculatorOperator{

    public Pop() {}

    @Override
    public void execute(ExecutionContext executionContext) {
        executionContext.getStack().pop();
    }
}
