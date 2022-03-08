import CodeParser.TokensReader;
import Common.CalculatorToken;

import java.io.IOException;

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

        tokensReader.parseInput();
        try {
            while (!tokensReader.isEmpty()) {
                Iterable<CalculatorToken> tokens = tokensReader.getNextLineTokens();

            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
