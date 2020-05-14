package pl.codeleak.samples.java14.switch_statement;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static pl.codeleak.samples.java14.switch_statement.Calculator.calculate;

class Calculator {
    static double calculate(String operator, double x, double y) {
        return switch (operator) {
            case "+" -> x + y;
            case "-" -> x - y;
            case "*" -> x * y;
            case "/" -> {
                if (y == 0) {
                    throw new IllegalArgumentException("Can't divide by 0");
                }
                yield x / y;
            }
            default -> throw new IllegalArgumentException("Unknown operator '%s'".formatted(operator));
        };
    }
}

class Java14CalculatorWithSwitchTests {

    @Test
    void adds() {
        assertThat(calculate("+", 10, 10)).isEqualTo(20);
    }

    @Test
    void subtract() {
        assertThat(calculate("-", 10, 10)).isEqualTo(0);
    }

    @Test
    void multiplies() {
        assertThat(calculate("*", 10, 10)).isEqualTo(100);
    }

    @Test
    void divides() {
        assertThat(calculate("/", 10, 10)).isEqualTo(1);
    }

    @Test
    void divisionByZeroThrowsException() {
        assertThatThrownBy(() -> calculate("/", 10, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Can't divide by 0");
    }

    @Test
    void notSupportedOperatorThrowsException() {
        assertThatThrownBy(() -> calculate("Bad", 10, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Unknown operator 'Bad'");
    }
}


