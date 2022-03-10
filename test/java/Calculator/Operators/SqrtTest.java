package Calculator.Operators;

import Calculator.ExecutionContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class SqrtTest {
    @Test
    @DisplayName("Execute with correct args")
    void executeCorrect() {
        Sqrt operator = new Sqrt();
        double arg = 1.0;

        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(arg);

        assertDoesNotThrow(() -> operator.execute(executionContext));
        Stack<Double> stack = executionContext.getStack();
        assertAll(
                () -> assertEquals(1, stack.size()),
                () -> assertEquals(Math.sqrt(arg), stack.peek())
        );
    }

    @Test
    @DisplayName("Execute with incorrect args")
    void executeIncorrect() {
        Sqrt operator = new Sqrt();
        double arg = -1.0;

        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(arg);

        assertThrows(Exception.class, () -> operator.execute(executionContext));
    }
}