package Calculator.Operators;

import Calculator.ExecutionContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class PopTest {

    @Test
    @DisplayName("Execute with correct args")
    void executeCorrect() {
        Pop operator = new Pop();

        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(1.0);
        assertDoesNotThrow(() -> operator.execute(executionContext));
        Stack<Double> stack = executionContext.getStack();
        assertEquals(0, stack.size());
    }

    @Test
    @DisplayName("Execute with incorrect args")
    void executeIncorrect() {
        Pop operator = new Pop();
        ExecutionContext executionContext = new ExecutionContext();
        assertThrows(Exception.class, () -> operator.execute(executionContext));
    }

}