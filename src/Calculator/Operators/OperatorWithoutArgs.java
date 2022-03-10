package Calculator.Operators;

import Calculator.Common.CalculatorToken;

import java.util.List;

abstract public class OperatorWithoutArgs extends BaseOperator {
    @Override
    public void passArgs(List<CalculatorToken> args) {}
}
