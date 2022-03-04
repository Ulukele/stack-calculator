package CodeParser;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CodeReader {
    private final String filename;
    private final Queue<String> lines;

    public CodeReader(String filename) {
        this.filename = filename;
        this.lines = new LinkedList<>();
    }

    public void parseFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    // Returns null if there is no lines
    public Iterable<String> getNextLineTokens() throws IOException {
        if (lines.isEmpty()) return null;
        Reader reader = new BufferedReader(new StringReader(lines.remove()));
        StreamTokenizer streamTokenizer = new StreamTokenizer(reader);

        List<String> tokens = new ArrayList<>();
        int currentToken = streamTokenizer.nextToken();
        while (currentToken != StreamTokenizer.TT_EOF) {
            tokens.add(streamTokenizer.sval);
            currentToken = streamTokenizer.nextToken();
        }
        return tokens;
    }

    public boolean isEmpty() {
        return lines.isEmpty();
    }
}
