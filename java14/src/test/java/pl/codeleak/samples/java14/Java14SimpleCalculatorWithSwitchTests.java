package pl.codeleak.samples.java14;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static pl.codeleak.samples.java14.SimpleCalculator.calculate;

class Java14SimpleCalculatorWithSwitchTests {

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


