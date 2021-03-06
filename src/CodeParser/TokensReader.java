package CodeParser;

import Calculator.Common.CalculatorToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TokensReader {

    // Returns null if there is no lines or this is comment line
    static public List<CalculatorToken> getNextLineTokens(String line) throws IOException {
        if (line == null) return null;
        Reader reader = new BufferedReader(new StringReader(line));
        StreamTokenizer streamTokenizer = new StreamTokenizer(reader);
        streamTokenizer.wordChars('%', '/');
        streamTokenizer.commentChar('#');

        List<CalculatorToken> tokens = new ArrayList<>();
        int currentToken = streamTokenizer.nextToken();
        while (currentToken != StreamTokenizer.TT_EOF) {
            if (streamTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                tokens.add(new CalculatorToken(streamTokenizer.nval));
            } else if (streamTokenizer.ttype == StreamTokenizer.TT_WORD) {
                tokens.add(new CalculatorToken(streamTokenizer.sval));
            }
            currentToken = streamTokenizer.nextToken();
        }
        if (tokens.size() == 0) return null;
        return tokens;
    }
}
