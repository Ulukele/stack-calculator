package Calculator.OperatorsFactory;

import Calculator.Exceptions.FactoryException;
import Calculator.Operators.CalculatorOperatorInterface;
import Calculator.OperatorsExecutor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Logger;

public class OperatorsFactory {
    private final Properties properties;
    private final Logger logger = Logger.getLogger(OperatorsFactory.class.getName());

    public OperatorsFactory() throws FactoryException {
        properties = new Properties();
        initMapping();
    }

    private void initMapping() throws FactoryException {
        String configFile = "configuration.properties";
        InputStream resourceStream = OperatorsFactory.class.getResourceAsStream(configFile);
        try {
            properties.load(resourceStream);
            logger.config("Factory configs:\n" + properties.toString());
        } catch (IOException ioException) {
            throw new FactoryException("Error while reading configuration file", ioException);
        }
        logger.fine("Configure factory successfully");
    }

    public CalculatorOperatorInterface getInstance(String operatorName) throws FactoryException {
        String className = properties.getProperty(operatorName);
        if (className == null) throw new FactoryException("Expect correct operator name, got " + operatorName);

        CalculatorOperatorInterface operator;
        try {
            Class<?> operatorClass = Class.forName(className);
            logger.fine("Find class " + operatorClass.getName() + " for name " + operatorName);
            operator = (CalculatorOperatorInterface)operatorClass.getDeclaredConstructor().newInstance();
            logger.fine("Create new instance of " + operator.getClass().getName());
        } catch (ClassNotFoundException exception) {
            throw new FactoryException("Can't find such class " + className, exception);
        } catch (ReflectiveOperationException exception) {
            throw new FactoryException("Can't find class constructor for " + className, exception);
        }
        return operator;
    }
}
