package CodeParser;

import org.junit.jupiter.api.*;

import java.io.StringReader;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LineReaderTest {
    private static final ArrayList<String> lines = new ArrayList<>();
    private static LineReader lineReader = null;

    @BeforeAll
    static void init() {
        lines.add("PUSH 1");
        lines.add("# added 1");
        lines.add("PUSH 2");
        lines.add("+");

        String linesString = String.join("\n", lines);
        StringReader stringReader = new StringReader(linesString);

        lineReader = new LineReader(stringReader);
    }

    @Test
    @Order(1)
    @DisplayName("Read all lines")
    void readAll() {
        assertDoesNotThrow(lineReader::readAll);
    }

    @Test
    @Order(2)
    @DisplayName("Check lines")
    void checkLines() {
        ArrayList<String> returnedLines = new ArrayList<>();
        while (!lineReader.isEmpty()) {
            returnedLines.add(lineReader.getNextLine());
        }
        assertArrayEquals(lines.toArray(), returnedLines.toArray());
    }
}