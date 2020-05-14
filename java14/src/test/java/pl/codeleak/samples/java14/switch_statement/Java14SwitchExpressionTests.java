package pl.codeleak.samples.java14.switch_statement;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Java14SwitchExpressionTests {

    @Test
    void switchAsAnExpressionWithLambdaLikeSyntax() {
        assertThat(switchAsAnExpression("A")).isEqualTo(1);
        assertThat(switchAsAnExpression("B")).isEqualTo(2);
        assertThat(switchAsAnExpression("C")).isEqualTo(3);
        assertThatThrownBy(() -> switchAsAnExpression("Wrong")).hasMessage("Unexpected value: Wrong");
    }

    private int switchAsAnExpression(String str) {
        var result = switch (str) {
            case "A" -> 1;
            case "B" -> 2;
            case "C" -> {
                System.out.println("3!");
                yield 3; // return
            }
            default -> throw new IllegalStateException("Unexpected value: " + str);
        };
        return result;
    }

    @Test
    void switchAsAStatementWithLambdaLikeSyntax() {
        assertThat(switchAsAStatement("A")).isEqualTo(1);
        assertThat(switchAsAStatement("B")).isEqualTo(2);
        assertThat(switchAsAStatement("C")).isEqualTo(3);
        assertThat(switchAsAStatement("!")).isEqualTo(-1);
    }

    private int switchAsAStatement(String str) {
        int result;
        switch (str) {
            case "A" -> result = 1;
            case "B" -> result = 2;
            case "C" -> {
                result = 3;
                System.out.println("3!");
            }
            default -> {
                System.err.println("Unexpected value: " + str);
                result = -1;
            }
        }
        return result;
    }

    @Test
    void switchWithMultipleConstantsPerCase() {
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
            case "D", "E", "F" -> 4; // multiple values separated by comma
            default -> -1;
        };
        return result;
    }
}
