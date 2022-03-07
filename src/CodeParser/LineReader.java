package CodeParser;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class LineReader {
    private final String filename;
    private final Queue<String> lines = new LinkedList<>();

    public LineReader(String filename) {
        this.filename = filename;
    }

    public LineReader() {
        this.filename = null;
    }

    private void readFromBufferedReader(BufferedReader bufferedReader) throws IOException {
        String line = bufferedReader.readLine();
        while (line != null) {
            lines.add(line);
            line = bufferedReader.readLine();
        }
    }

    private void readFromFile() throws IOException {
        if (filename == null) return;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            readFromBufferedReader(reader);
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }

    private void readFromStandardInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        readFromBufferedReader(reader);
    }

    public void readAll() {
        try {
            if (filename == null) {
                readFromStandardInput();
            } else {
                readFromFile();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
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
