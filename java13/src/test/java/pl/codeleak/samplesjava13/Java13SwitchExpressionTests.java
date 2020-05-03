package pl.codeleak.samplesjava13;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Java13SwitchExpressionTests {

    @Test
    void switchExpressionWithLambdaExpressions() {
        assertThat(switchString("A")).isEqualTo(1);
        assertThat(switchString("B")).isEqualTo(2);
        assertThat(switchString("C")).isEqualTo(3);
        assertThatThrownBy(() -> switchString("Wrong")).hasMessage("Unexpected value: Wrong");
    }

    private int switchString(String str) {
        var result = switch (str) {
            case "A" -> 1;
            case "B" -> 2;
            case "C" -> {
                System.out.println("March!");
                yield 3; // return
            }
            default -> throw new IllegalStateException("Unexpected value: " + str);
        };
        return result;
    }
}
