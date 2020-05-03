package pl.codeleak.samples.java12;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Java12StringTransformTests {

    @Test
    void transformString() {
        var result = "This is a good example".transform(s -> s + "!".repeat(3));

        assertThat(result).isEqualTo("This is a good example!!!");
    }

    @Test
    void transformStringIntoBigDecimal() {
        var result = "101".transform(BigDecimal::new);

        assertThat(result).isEqualTo(BigDecimal.valueOf(101));
    }

    @Test
    void transformStringIntoAnArray() {
        var result = "a,b,c".transform(s -> s.split(","));

        assertThat(result).isEqualTo(new String[]{"a", "b", "c"});
    }
}
