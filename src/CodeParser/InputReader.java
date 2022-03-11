package CodeParser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * Reads from file or from standard input
 */
public class InputReader {
    private String filename = null;

    public InputReader() {}

    public InputReader(String filename) {
        this.filename = filename;
    }

    public Reader getReader() throws FileNotFoundException {
        if (filename == null) {
            return new InputStreamReader(System.in);
        } else {
            return new FileReader(filename);
        }
    }
}
