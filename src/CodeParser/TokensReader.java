package CodeParser;

import Common.CalculatorToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TokensReader {

    private final LineReader lineReader;

    public TokensReader(String filename) {
        lineReader = new LineReader(filename);
    }

    public TokensReader() {
        lineReader = new LineReader();
    }

    public void parseInput() {
        lineReader.readAll();
    }

    // Returns null if there is no lines or this is comment line
    public List<CalculatorToken> getNextLineTokens() throws IOException {
        if (lineReader.isEmpty()) return null;
        Reader reader = new BufferedReader(new StringReader(lineReader.getNextLine()));
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

    public boolean isEmpty() {
        return lineReader.isEmpty();
    }
}
