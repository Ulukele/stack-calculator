package Calculator.Exceptions;

import Calculator.Common.CalculatorToken;

public class OperatorArgsException extends OperatorException {
    public OperatorArgsException(Iterable<CalculatorToken> args, String message) {
        super("Arguments provided: " + args.toString() + ". " + message);
    }
    public OperatorArgsException(String message) {
        super(message);
    }
}
