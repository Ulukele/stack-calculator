package Calculator.OperatorsFactory;

import Calculator.Exceptions.FactoryException;
import Calculator.Operators.CalculatorOperatorInterface;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class OperatorsFactory {
    private final Properties properties;

    public OperatorsFactory() throws FactoryException {
        properties = new Properties();
        initMapping();
    }

    private void initMapping() throws FactoryException {
        String configFile = "configuration.properties";
        InputStream resourceStream = OperatorsFactory.class.getResourceAsStream(configFile);
        try {
            properties.load(resourceStream);
        } catch (IOException ioException) {
            throw new FactoryException("Error while reading configuration file", ioException);
        }
    }

    public CalculatorOperatorInterface getInstance(String operatorName) throws FactoryException {
        String className = properties.getProperty(operatorName);
        if (className == null) throw new FactoryException("Expect correct operator name, got " + operatorName);

        CalculatorOperatorInterface operator;
        try {
            Class<?> operatorClass = Class.forName(className);
            operator = (CalculatorOperatorInterface)operatorClass.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException exception) {
            throw new FactoryException("Can't find such class " + className, exception);
        } catch (ReflectiveOperationException exception) {
            throw new FactoryException("Can't find class constructor for " + className, exception);
        }
        return operator;
    }
}
