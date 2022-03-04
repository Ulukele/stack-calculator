import CodeParser.CodeReader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.err.println("Need specify file");
            return;
        } else if (args.length > 1) {
            System.err.println("Too much arguments");
            return;
        }

        CodeReader codeReader = new CodeReader(args[0]);
        codeReader.parseFile();
        try {
            while (!codeReader.isEmpty()) {
                Iterable<String> tokens = codeReader.getNextLineTokens();
                // pass to factory
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }

    }
}
