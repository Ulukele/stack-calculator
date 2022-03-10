package Calculator.Operators;

import Calculator.ExecutionContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class SubTest {
    @Test
    @DisplayName("Execute with correct args")
    void executeCorrect() {
        Sub operator = new Sub();
        Double first = 1.0;
        Double second = 5.0;

        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(first);
        executionContext.getStack().push(second);

        assertDoesNotThrow(() -> operator.execute(executionContext));
        Stack<Double> stack = executionContext.getStack();
        assertAll(
                () -> assertEquals(1, stack.size()),
                () -> assertEquals(second - first, stack.peek())
        );
    }
}