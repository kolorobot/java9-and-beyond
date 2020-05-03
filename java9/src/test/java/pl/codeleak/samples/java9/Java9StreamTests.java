package pl.codeleak.samples.java9;

import org.junit.jupiter.api.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Java 9 Stream API - dropWhile, takeWhile, ofNullable")
class Java9StreamTests {

    @Test
    void takeWhileIsEvenNumber() {
        List<Integer> list = List.of(2, 4, 6, 8, 9, 10, 12);

        // get even numbers
        List<Integer> result = list.stream()
                .takeWhile(n -> n % 2 == 0)
                .collect(Collectors.toList());

        // assert
        assertThat(result).containsSequence(2, 4, 6, 8);
    }

    @Test
    void takeWhileIsStartingWithA() {
        List<String> list = List.of("abc", "aed", "age", "dwe", "cde", "asr");

        // get strings starting with "a"
        List<String> result = list.stream()
                .takeWhile(s -> s.startsWith("a"))
                .collect(Collectors.toList());

        // assert
        assertThat(result).containsSequence("abc", "aed", "age");
    }

    @Test
    void dropWhileIsOddNumber() {
        List<Integer> list = List.of(2, 4, 6, 8, 9, 10, 12);

        // print numbers
        List<Integer> result = list.stream()
                .dropWhile(n -> n % 2 == 0)
                .collect(Collectors.toList());

        // assert
        assertThat(result).containsSequence(9, 10, 12);
    }

    @Test
    void dropWhileIsStartingWithA() {
        List<String> list = List.of("abc", "aed", "age", "dwe", "cde", "asr");

        // drop strings starting with "a"
        List<String> result = list.stream()
                .dropWhile(s -> s.startsWith("a"))
                .collect(Collectors.toList());

        // assert
        assertThat(result).containsSequence("dwe", "cde", "asr");
    }

    @Test
    void ofNullable() {
        List<Object> list = Stream.ofNullable(null)
                .collect(Collectors.toList());

        assertThat(list).isEmpty();
    }

    @Test
    void optionalToStream() {
        assertThat(Optional.empty().stream()).isEmpty();
        assertThat(Optional.ofNullable(null).stream()).isEmpty();
        assertThat(Optional.of(1).stream()).hasSize(1);
    }
}
