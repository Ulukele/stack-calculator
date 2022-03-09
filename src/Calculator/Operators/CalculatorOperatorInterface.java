package Calculator.Operators;

import Calculator.Exceptions.CalculationException;
import Calculator.Exceptions.CalculatorExecutionContextException;
import Calculator.Exceptions.OperatorArgsInterpretException;
import Calculator.Exceptions.OperatorException;
import Calculator.ExecutionContext;
import Calculator.Common.CalculatorToken;

import java.util.List;

public interface CalculatorOperatorInterface {
    void passArgs(List<CalculatorToken> args);
    void execute(ExecutionContext executionContext)
            throws CalculatorExecutionContextException, OperatorException, CalculationException;
}
