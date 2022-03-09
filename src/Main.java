import Calculator.Operators.CalculatorOperatorInterface;
import Calculator.OperatorsExecutor;
import Calculator.OperatorsFactory.OperatorsFactory;
import CodeParser.TokensReader;
import Calculator.Common.CalculatorOperation;
import Calculator.Common.CalculatorToken;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        TokensReader tokensReader = null;
        if (args.length == 0) {
            tokensReader = new TokensReader(); // from file
        } else if (args.length == 1) {
            tokensReader = new TokensReader(args[0]); // from standard stream
        }
        if (tokensReader == null) {
            System.err.println("Specify only 1 argument -- filename");
            return;
        }

        OperatorsExecutor executor = new OperatorsExecutor();
        OperatorsFactory operatorsFactory = new OperatorsFactory();
        tokensReader.parseInput();
        while (!tokensReader.isEmpty()) {
            try {
                List<CalculatorToken> tokens = tokensReader.getNextLineTokens();
                if (tokens == null) continue; // Comment line
                CalculatorOperation calculatorOperation = new CalculatorOperation(tokens);
                CalculatorOperatorInterface operator = operatorsFactory.getInstance(calculatorOperation.getOperatorName());
                operator.passArgs(calculatorOperation.getArgs());
                executor.executeOne(operator);
            } catch (Exception exception) {
                exception.printStackTrace(System.out);
            }
        }

    }
}
