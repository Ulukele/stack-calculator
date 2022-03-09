package Calculator.Common;

import Calculator.Exceptions.OperatorArgsInterpretException;

import javax.lang.model.SourceVersion;

/**
 * Value class for operators arguments
 * can be interpreted as double or as string
 * throw exception if you can't interpret in needed way
 */
public class CalculatorToken {
    private String stringValue = null;
    private Double numberValue = null;

    public CalculatorToken(String stringValue) {
        this.stringValue = stringValue;
    }
    public CalculatorToken(Double numberValue) {
        this.numberValue = numberValue;
    }

    public String toString() {
        if (stringValue != null) return stringValue;
        stringValue = numberValue.toString();
        return stringValue;
    }

    public Double toDouble() throws OperatorArgsInterpretException {
        if (numberValue != null) return numberValue;
        try {
            numberValue = Double.valueOf(stringValue);
            return numberValue;
        }
        catch (NumberFormatException e) {
            throw new OperatorArgsInterpretException(stringValue);
        }
    }

    public boolean isIdentifier() {
        return SourceVersion.isIdentifier(toString());
    }

}
