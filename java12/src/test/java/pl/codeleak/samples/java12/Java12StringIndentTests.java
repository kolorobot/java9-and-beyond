package pl.codeleak.samples.java12;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Java12StringIndentTests {
    @Test
    void indentByAddingLines() {
        var str = "Line 1\nLine 2\nLine 3";

        var result = str.indent(2);

        assertThat(result).isEqualTo("  Line 1\n  Line 2\n  Line 3\n"); // a new line is added to the end of the new string

    }

    @Test
    void indentByRemovingLines() {
        var str = "Line 1\n Line 2\n  Line 3";

        var result = str.indent(-2);

        assertThat(result).isEqualTo("Line 1\nLine 2\nLine 3\n"); // a new line is added to the end of the new string

    }
}
