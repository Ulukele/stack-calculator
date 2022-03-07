package Common;

/**
 * Value class for operators arguments
 * can be interpreted as double or as string
 * throw exception if you can't interpret in needed way
 */
public class CalculatorToken {
    private String value = null;
    private Double numberValue = null;

    public CalculatorToken(String value) {
        this.value = value;
    }
    public CalculatorToken(Double numberValue) {
        this.numberValue = numberValue;
    }

    public String toString() {
        if (value != null) return value;
        value = numberValue.toString();
        return value;
    }

    public Double toDouble() throws UnsupportedOperationException {
        if (numberValue != null) return numberValue;
        try {
            numberValue = Double.valueOf(value);
            return numberValue;
        }
        catch (NumberFormatException e) {
            throw new UnsupportedOperationException("Expect double value, got " + value);
        }
    }

}
