package Common;

/**
 * Value class for operators arguments
 * can be interpreted as double or as string
 * throw exception if you can't interpret in needed way
 */
public class OperatorArgument {
    private final String value;
    private Double numberValue = null;

    public OperatorArgument(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }

    public Double toDouble() {
        if (numberValue != null) {
            return numberValue;
        }
        try {
            numberValue = Double.valueOf(value);
            return numberValue;
        }
        catch (NumberFormatException e) {
            throw new UnsupportedOperationException();
        }
    }

}
