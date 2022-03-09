package Calculator.Exceptions;

public class OperatorArgsInterpretException extends OperatorArgsException {
    public OperatorArgsInterpretException(String tokenString) {
        super("Can't interpret token '" + tokenString + "' as number");
    }
}
