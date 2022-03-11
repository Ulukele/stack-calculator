package CodeParser;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class LineReader {
    private final Reader reader;
    private final Queue<String> lines = new LinkedList<>();

    public LineReader(Reader reader) {
        this.reader = reader;
    }

    public void readAll() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        while (line != null) {
            lines.add(line);
            line = bufferedReader.readLine();
        }
    }

    public String getNextLine() {
        if (lines.isEmpty()) return null;
        return lines.remove();
    }

    public boolean isEmpty() {
        return lines.isEmpty();
    }
}
