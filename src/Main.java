import Calculator.Exceptions.CalculatorException;
import Calculator.Exceptions.FactoryException;
import Calculator.Operators.CalculatorOperatorInterface;
import Calculator.OperatorsExecutor;
import Calculator.OperatorsFactory.OperatorsFactory;
import CodeParser.InputReader;
import CodeParser.LineReader;
import CodeParser.TokensReader;
import Calculator.Common.CalculatorOperation;
import Calculator.Common.CalculatorToken;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {

        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logger.properties"));
        } catch (IOException exception) {
            System.err.println("Error while opening logger configuration: " + exception.toString());
        }

        InputReader inputReader = null;
        if (args.length == 0) {
            inputReader = new InputReader(); // from standard stream
        } else if (args.length == 1) {
            inputReader = new InputReader(args[0]); // from file
        }
        if (inputReader == null) {
            logger.severe("Specify only 1 argument -- filename");
            return;
        }

        LineReader lineReader;
        try {
            lineReader = new LineReader(inputReader.getReader());
            lineReader.readAll();
        } catch (IOException exception) {
            logger.log(Level.SEVERE, "IOException: ", exception);
            return;
        }

        OperatorsExecutor executor = new OperatorsExecutor();
        OperatorsFactory operatorsFactory = new OperatorsFactory();
        while (!lineReader.isEmpty()) {
            try {
                String line = lineReader.getNextLine();
                logger.info("Code line: " + line);
                List<CalculatorToken> tokens = TokensReader.getNextLineTokens(line);
                if (tokens == null) continue; // Comment line
                CalculatorOperation calculatorOperation = new CalculatorOperation(tokens);
                CalculatorOperatorInterface operator = operatorsFactory.getInstance(calculatorOperation.getOperatorName());
                operator.passArgs(calculatorOperation.getArgs());
                executor.executeOne(operator);
            } catch (IOException | FactoryException exception) {
                logger.log(Level.SEVERE, "Fatal Error: ", exception);
                return;
            } catch (CalculatorException calculatorException) {
                logger.log(Level.WARNING, "CalculatorException: ", calculatorException);
            }
        }
    }
}
