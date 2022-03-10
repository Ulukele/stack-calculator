package Calculator.OperatorsFactory;

import Calculator.Exceptions.FactoryException;
import Calculator.Operators.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorsFactoryTest {
    private final OperatorsFactory operatorsFactory = new OperatorsFactory();

    @Test
    @DisplayName("Gets PUSH operator instance")
    void getPush() {
        assertInstanceOf(Push.class, operatorsFactory.getInstance("PUSH"));
    }

    @Test
    @DisplayName("Gets POP operator instance")
    void getPop() {
        assertInstanceOf(Pop.class, operatorsFactory.getInstance("POP"));
    }

    @Test
    @DisplayName("Gets + operator instance")
    void getSum() {
        assertInstanceOf(Sum.class, operatorsFactory.getInstance("+"));
    }

    @Test
    @DisplayName("Gets - operator instance")
    void getSub() {
        assertInstanceOf(Sub.class, operatorsFactory.getInstance("-"));
    }

    @Test
    @DisplayName("Gets * operator instance")
    void getMultiply() {
        assertInstanceOf(Multiply.class, operatorsFactory.getInstance("*"));
    }

    @Test
    @DisplayName("Gets / operator instance")
    void getDivide() {
        assertInstanceOf(Divide.class, operatorsFactory.getInstance("/"));
    }

    @Test
    @DisplayName("Gets DEFINE operator instance")
    void getDefine() {
        assertInstanceOf(Define.class, operatorsFactory.getInstance("DEFINE"));
    }

    @Test
    @DisplayName("Gets PRINT operator instance")
    void getPrint() {
        assertInstanceOf(Print.class, operatorsFactory.getInstance("PRINT"));
    }

    @Test
    @DisplayName("Try to get by incorrect name")
    void getIncorrect() {
        assertThrows(FactoryException.class, () -> operatorsFactory.getInstance("Print"));
    }
}