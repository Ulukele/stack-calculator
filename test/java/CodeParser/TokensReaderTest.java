package CodeParser;

import Calculator.Common.CalculatorToken;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TokensReaderTest {

    @Test
    @DisplayName("Pass null shouldn't throw any")
    void nullLineDoesNotThrow() {
        assertDoesNotThrow(() -> TokensReader.getNextLineTokens(null));
    }

    @Test
    @DisplayName("Pass null should return null")
    void nullLine() {
        assertDoesNotThrow(() -> assertNull(TokensReader.getNextLineTokens(null)));
    }

    @Test
    @DisplayName("Pass comment line")
    void commentLine() {
        assertDoesNotThrow(() -> assertNull(TokensReader.getNextLineTokens("# comment line")));
        assertDoesNotThrow(() -> assertNull(TokensReader.getNextLineTokens("#another one")));
    }


    @Test
    @DisplayName("Pass correct line shouldn't throw any")
    void correctLine() {
        assertDoesNotThrow( () -> TokensReader.getNextLineTokens("DEFINE variable 1") );
    }

    @Test
    @DisplayName("Pass correct line, check result")
    void correctLineResult() throws IOException {
        List<CalculatorToken> tokens = TokensReader.getNextLineTokens("DEFINE variable 1");
        assertAll(
                () -> assertEquals("DEFINE", tokens.get(0).toString()),
                () -> assertEquals("variable", tokens.get(1).toString()),
                () -> assertEquals(1.0, tokens.get(2).toDouble())
        );
    }

}