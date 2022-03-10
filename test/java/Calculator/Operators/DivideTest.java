package Calculator.Operators;

import Calculator.ExecutionContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class DivideTest {

    @Test
    @DisplayName("Execute with correct args")
    void executeCorrect() {
        Divide operator = new Divide();
        Double first = 1.0;
        Double second = 5.0;

        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(first);
        executionContext.getStack().push(second);

        assertDoesNotThrow(() -> operator.execute(executionContext));
        Stack<Double> stack = executionContext.getStack();
        assertAll(
                () -> assertEquals(1, stack.size()),
                () -> assertEquals(second / first, stack.peek())
        );
    }

    @Test
    @DisplayName("Execute with incorrect args")
    void executeIncorrect() {
        Divide operator = new Divide();
        Double first = 0.0;
        Double second = 5.0;

        ExecutionContext executionContext = new ExecutionContext();
        executionContext.getStack().push(first);
        executionContext.getStack().push(second);

        assertThrows(Exception.class, () -> operator.execute(executionContext));
    }

}