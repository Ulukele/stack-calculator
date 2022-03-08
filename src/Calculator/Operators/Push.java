package Calculator.Operators;

import Calculator.ExecutionContext;

public class Push extends OperatorWithArgs {
    public Push() {}

    @Override
    public void execute(ExecutionContext executionContext) throws UnsupportedOperationException {
        if (args.size() == 1) {
            Double value = args.get(0).toDouble();
            executionContext.getStack().push(value);
        } else {
            throw new UnsupportedOperationException("Expect 1 argument, got " + args.size());
        }
    }
}
