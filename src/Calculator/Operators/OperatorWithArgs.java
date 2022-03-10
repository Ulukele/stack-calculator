package Calculator.Operators;

import Calculator.Common.CalculatorToken;

import java.util.List;

abstract public class OperatorWithArgs extends BaseOperator {
    protected List<CalculatorToken> args = null;
    @Override
    public void passArgs(List<CalculatorToken> args) {
        this.args = args;
    }
}
