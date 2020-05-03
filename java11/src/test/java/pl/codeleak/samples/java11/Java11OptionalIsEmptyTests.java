package pl.codeleak.samples.java11;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class Java11OptionalIsEmptyTests {
    @Test
    void optionalIsEmpty() {

        var empty = Optional.empty();
        assertThat(empty.isEmpty()).isTrue();

        var anotherEmpty = Optional.ofNullable(null);
        assertThat(anotherEmpty.isEmpty()).isTrue();
    }
}
