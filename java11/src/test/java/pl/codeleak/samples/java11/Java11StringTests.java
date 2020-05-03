package pl.codeleak.samples.java11;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Java11StringTests {

    @Test
    void strip() {
        var str = " DEMO ";
        assertThat(str.strip()).isEqualTo("DEMO");
    }

    @Test
    void stripLeading() {
        var str = " DEMO ";
        assertThat(str.stripLeading()).isEqualTo("DEMO ");
    }

    @Test
    void stripTrailing() {
        var str = " DEMO ";
        assertThat(str.stripTrailing()).isEqualTo(" DEMO");
    }

    @Test
    void isBlank() {
        assertThat("  ".isBlank()).isTrue();
        assertThat("".isBlank()).isTrue();
        assertThat("x".isBlank()).isFalse();
    }

    @Test
    void lines() {
        var multilineString = "line1\nline2\nline3";

        assertThat(multilineString.lines()).containsExactly("line1", "line2", "line3");
    }

    @Test
    void repeat() {
        var str = "-str-";
        var newStr = str.repeat(3);

        assertThat(newStr).isEqualTo("-str--str--str-");
    }
}
