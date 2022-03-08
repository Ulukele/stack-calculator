package Calculator.OperatorsFactory;

import Calculator.Operators.CalculatorOperatorInterface;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class OperatorsFactory {
    private final Properties properties;

    public OperatorsFactory() {
        properties = new Properties();
        initMapping();
    }

    private void initMapping() {
//        String configFile = "src/Calculator/OperatorsFactory/configuration.properties";
        String configFile = "configuration.properties";
        InputStream resourceStream = OperatorsFactory.class.getResourceAsStream(configFile);
        try {
            properties.load(resourceStream);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public CalculatorOperatorInterface getInstance(String operatorName) throws IllegalArgumentException {
        String className = properties.getProperty(operatorName);
        if (className == null) throw new IllegalArgumentException("Expect correct operator name, got " + operatorName);

        CalculatorOperatorInterface operator;
        try {
            Class<?> operatorClass = Class.forName(className);
            operator = (CalculatorOperatorInterface)operatorClass.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException exception) {
            throw new IllegalArgumentException("Can't find such class " + className);
        } catch (ReflectiveOperationException exception) {
            throw new IllegalArgumentException("Can't find class constructor for " + className);
        }
        return operator;
    }
}
