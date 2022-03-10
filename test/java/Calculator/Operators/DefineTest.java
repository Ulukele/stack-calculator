package Calculator.Operators;

import Calculator.Common.CalculatorToken;
import Calculator.ExecutionContext;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class DefineTest {

    @Test
    @DisplayName("Execute with correct args")
    void executeCorrect() {
        Define operator = new Define();
        String identifier = "identifier";
        Double value = 1.0;

        List<CalculatorToken> args = new ArrayList<>();
        args.add(new CalculatorToken(identifier));
        args.add(new CalculatorToken(value));
        operator.passArgs(args);

        ExecutionContext executionContext = new ExecutionContext();
        assertDoesNotThrow(() -> operator.execute(executionContext));
        Map<String, Double> variables = executionContext.getVariables();
        assertEquals(value, variables.get(identifier));
    }

    @Test
    @DisplayName("Execute with incorrect args")
    void executeIncorrect() {
        Define operator = new Define();
        String identifier = "4_incorrect_identifier";
        Double value = 1.0;

        List<CalculatorToken> args = new ArrayList<>();
        args.add(new CalculatorToken(identifier));
        args.add(new CalculatorToken(value));
        operator.passArgs(args);

        ExecutionContext executionContext = new ExecutionContext();
        assertThrows(Exception.class, () -> operator.execute(executionContext));
    }
}