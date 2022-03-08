package Calculator.OperatorsFactory;

import Calculator.Operators.CalculatorOperatorInterface;
import Calculator.Operators.Push;

import java.util.HashMap;
import java.util.Map;

public class OperatorsFactory {
    private final Map<String, String> nameMapping;

    OperatorsFactory(String configFile) {
        this.nameMapping = new HashMap<>();
        initMapping(configFile);
    }

    private void initMapping(String filename) {

    }

    public CalculatorOperatorInterface getInstance(String operatorName)
            throws ClassNotFoundException, IllegalArgumentException {
        String className = nameMapping.get(operatorName);
        if (className == null) throw new IllegalArgumentException("Expect correct operator name, got " + operatorName);
        // return instance

        return new Push();
    }
}
