package Calculator;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Logger;

public class ExecutionContext {
    private final Stack<Double> stack;
    private final Map<String, Double> variables;
    private final Logger logger = Logger.getLogger(ExecutionContext.class.getName());

    public ExecutionContext() {
        stack = new Stack<>();
        variables = new HashMap<>();
    }

    public Stack<Double> getStack() {
        logger.fine("Request stack");
        return stack;
    }

    public Map<String, Double> getVariables() {
        logger.fine("Request variables");
        return variables;
    }
}
