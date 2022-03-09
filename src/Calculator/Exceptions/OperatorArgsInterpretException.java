package Calculator.Exceptions;

import Calculator.Common.CalculatorToken;

public class OperatorArgsInterpretException extends OperatorArgsException {
    public OperatorArgsInterpretException(String message) {
        super(message);
    }
    public OperatorArgsInterpretException(CalculatorToken token) {
        super("Can't interpret token '" + token.toString()+ "' as number");
    }
}
