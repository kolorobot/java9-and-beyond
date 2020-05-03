package pl.codeleak.samples.java12;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Java12SwitchExpressionTests {

    @Test
    void switchExpressionWithLambdaExpressions() {
        assertThat(switchString("A")).isEqualTo(1);
        assertThat(switchString("B")).isEqualTo(2);
        assertThat(switchString("C")).isEqualTo(3);
        assertThat(switchString("D")).isEqualTo(4);
        assertThat(switchString("E")).isEqualTo(4);
        assertThat(switchString("F")).isEqualTo(4);
        assertThat(switchString("G")).isEqualTo(-1);
    }

    private int switchString(String str) {
        var result = switch (str) {
            case "A" -> 1;
            case "B" -> 2;
            case "C" -> 3;
            case "D", "E", "F" -> 4;
            default -> -1;
        };
        return result;
    }
}
