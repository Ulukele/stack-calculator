package Calculator.Exceptions;

import Calculator.Common.CalculatorToken;

import java.util.List;

public class OperatorArgsCountException extends OperatorArgsException {
    public OperatorArgsCountException() { super(); }

    public OperatorArgsCountException(String message) {
        super(message);
    }

    public OperatorArgsCountException(List<CalculatorToken> args, int requireCount) {
        super(args, "Need " + requireCount + " args, got " + args.size());
    }
}
