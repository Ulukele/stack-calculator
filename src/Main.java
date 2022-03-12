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
import Logging.EventsLogger;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        try { // Setup logging
            EventsLogger.configure();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        InputReader inputReader = null;
        if (args.length == 0) {
            inputReader = new InputReader(); // from standard stream
        } else if (args.length == 1) {
            inputReader = new InputReader(args[0]); // from file
        }
        if (inputReader == null) {
            System.err.println("Specify only 1 argument -- filename");
            return;
        }

        LineReader lineReader;
        try {
            lineReader = new LineReader(inputReader.getReader());
            lineReader.readAll();
        } catch (IOException exception) {
            exception.printStackTrace();
            return;
        }

        OperatorsExecutor executor = new OperatorsExecutor();
        OperatorsFactory operatorsFactory = new OperatorsFactory();
        while (!lineReader.isEmpty()) {
            try {
                String line = lineReader.getNextLine();
                List<CalculatorToken> tokens = TokensReader.getNextLineTokens(line);
                if (tokens == null) continue; // Comment line
                CalculatorOperation calculatorOperation = new CalculatorOperation(tokens);
                CalculatorOperatorInterface operator = operatorsFactory.getInstance(calculatorOperation.getOperatorName());
                operator.passArgs(calculatorOperation.getArgs());
                executor.executeOne(operator);
            } catch (IOException | FactoryException exception) {
                exception.printStackTrace(System.out);
                return;
            } catch (CalculatorException calculatorException) {
                calculatorException.printStackTrace();
            }
        }
    }
}
