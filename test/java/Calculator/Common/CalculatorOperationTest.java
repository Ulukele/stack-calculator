package Calculator.Common;

import Calculator.Exceptions.CalculatorOperationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class CalculatorOperationTest {

    CalculatorOperation operation;
    final private List<CalculatorToken> tokensList = new ArrayList<>();
    final private CalculatorToken operatorName = new CalculatorToken("PUSH");
    final private CalculatorToken arg = new CalculatorToken(1.0);

    @BeforeEach
    @Test
    @DisplayName("Create correct operation")
    void prepare() {
        tokensList.add(operatorName);
        tokensList.add(arg);
        assertDoesNotThrow(() -> operation = new CalculatorOperation(tokensList));
    }

    @Test
    @DisplayName("Gets operator")
    void getOperatorName() {
        assertEquals(operatorName.toString(), operation.getOperatorName());
    }

    @Test
    @DisplayName("Gets args list")
    void getArgs() {
        Object[] actualArgs = operation.getArgs().toArray();
        Object[] expectedArgs = tokensList.subList(1, tokensList.size()).toArray();
        assertArrayEquals(expectedArgs, actualArgs);
    }

    @Test
    @DisplayName("Try to create with null")
    void createWithNull() {
        assertThrows(CalculatorOperationException.class, () -> new CalculatorOperation(null));
    }

    @Test
    @DisplayName("Try to create with empty list")
    void createWithEmptyList() {
        assertThrows(CalculatorOperationException.class, () -> new CalculatorOperation(new ArrayList<>()));
    }
}