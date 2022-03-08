package Calculator.OperatorsFactory;

import Calculator.Operators.CalculatorOperatorInterface;

import java.util.HashMap;
import java.util.Map;

public class OperatorsFactory {
    private final Map<String, String> nameMapping;

    public OperatorsFactory(String configFile) {
        this.nameMapping = new HashMap<>();
        initMapping(configFile);
    }

    private void initMapping(String filename) {

    }

    public CalculatorOperatorInterface getInstance(String operatorName) throws IllegalArgumentException {
        String className = nameMapping.get(operatorName);
        if (className == null) throw new IllegalArgumentException("Expect correct operator name, got " + operatorName);

        CalculatorOperatorInterface operator;
        try {
            Class<?> operatorClass = Class.forName(className);
            operator = (CalculatorOperatorInterface)operatorClass.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException exception) {
            throw new IllegalArgumentException("Can't find such class");
        } catch (ReflectiveOperationException exception) {
            throw new IllegalArgumentException("Can't find class constructor for " + className);
        }
        return operator;
    }
}
