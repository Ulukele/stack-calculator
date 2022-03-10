package Calculator.Operators;

import Calculator.Common.CalculatorToken;
import Calculator.Exceptions.OperatorArgsInterpretException;
import Calculator.Exceptions.OperatorException;
import Calculator.ExecutionContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class PushTest {

    @Test
    @DisplayName("Execute with correct args")
    void executeCorrect() {
        Push operator = new Push();
        Double arg = 1.0;

        List<CalculatorToken> args = new ArrayList<>();
        args.add(new CalculatorToken(arg));
        operator.passArgs(args);

        ExecutionContext executionContext = new ExecutionContext();
        assertDoesNotThrow(() -> operator.execute(executionContext));
        Stack<Double> stack = executionContext.getStack();
        assertAll(
                () -> assertEquals(1, stack.size()),
                () -> assertEquals(arg, stack.peek())
        );
    }

    @Test
    @DisplayName("Execute with incorrect args")
    void executeIncorrect() {
        Push operator = new Push();
        String arg = "incorrect";

        List<CalculatorToken> args = new ArrayList<>();
        args.add(new CalculatorToken(arg));
        operator.passArgs(args);

        ExecutionContext executionContext = new ExecutionContext();
        assertThrows(Exception.class, () -> operator.execute(executionContext));
    }

}