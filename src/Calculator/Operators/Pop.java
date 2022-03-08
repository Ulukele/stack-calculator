package Calculator.Operators;

import Calculator.ExecutionContext;

public class Pop extends OperatorWithoutArgs {
    public Pop() {}

    @Override
    public void execute(ExecutionContext executionContext) {
        executionContext.getStack().pop();
    }
}
