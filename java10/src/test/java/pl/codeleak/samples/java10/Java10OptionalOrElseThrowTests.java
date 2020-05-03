package pl.codeleak.samples.java10;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Java10OptionalOrElseThrowTests {

    @Test
    void getsValueOfNonEmptyOptions() {
        assertThat(nonEmptyOptional().orElseThrow(IllegalArgumentException::new)).isEqualTo("Some value");
    }

    @Test
    void throwsError() {
        assertThatThrownBy(() -> emptyOptional().orElseThrow(IllegalArgumentException::new))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> emptyOptional().orElseThrow(() -> new IllegalArgumentException("... with message")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("... with message");
    }

    private Optional<String> nonEmptyOptional() {
        return Optional.of("Some value");
    }

    private Optional<String> emptyOptional() {
        return Optional.empty();
    }
}
