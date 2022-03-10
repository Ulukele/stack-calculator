package Calculator.Common;

import Calculator.Exceptions.OperatorArgsInterpretException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTokenTest {

    @Test
    @DisplayName("Convert string-based token to string")
    void testToString() {
        CalculatorToken calculatorToken = new CalculatorToken("string-based");
        assertEquals("string-based", calculatorToken.toString());
    }

    @Test
    @DisplayName("Convert double-based token to double")
    void toDouble() {
        CalculatorToken calculatorToken = new CalculatorToken(1.234);
        assertDoesNotThrow(
                () -> assertEquals(1.234, calculatorToken.toDouble())
        );
    }

    @Test
    @DisplayName("Check correct identifier")
    void isIdentifier() {
        CalculatorToken calculatorToken = new CalculatorToken("correct_v4ri4ble");
        assertTrue(calculatorToken.isIdentifier());
    }

    @Test
    @DisplayName("Convert string-based token to double")
    void stringToDouble() {
        CalculatorToken calculatorToken = new CalculatorToken("Not number");
        assertThrows(
                OperatorArgsInterpretException.class,
                calculatorToken::toDouble
        );
    }

    @Test
    @DisplayName("Check incorrect identifiers")
    void isNotIdentifier() {
        assertAll(
                () -> assertFalse(new CalculatorToken(0.0).isIdentifier()),
                () -> assertFalse(new CalculatorToken(1.0).isIdentifier()),
                () -> assertFalse(new CalculatorToken("1ncorrect_v4ri4ble").isIdentifier()),
                () -> assertFalse(new CalculatorToken("&").isIdentifier()),
                () -> assertFalse(new CalculatorToken("1").isIdentifier())
        );
    }
}