package Calculator.Operators;

import Calculator.ExecutionContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class PrintTest {

    @Test
    @DisplayName("Execute with correct args")
    void executeCorrect() {
        Print operator = new Print();
        Double value = 1.0;

        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(value);
        assertDoesNotThrow(() -> operator.execute(executionContext));
        Stack<Double> stack = executionContext.getStack();
        assertAll(
                () -> assertEquals(1, stack.size()),
                () -> assertEquals(value.toString(), operator.getOutput())
        );
    }

    @Test
    @DisplayName("Execute with incorrect args")
    void executeIncorrect() {
        Print operator = new Print();
        ExecutionContext executionContext = new ExecutionContext();
        assertThrows(Exception.class, () -> operator.execute(executionContext));
    }
}