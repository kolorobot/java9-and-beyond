package pl.codeleak.samples.java10;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Java10CollectorsUnmodifiableTests {

    @Test
    void collectorsUnmodifiableList() {

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);

        List<Integer> result = stream.filter(i -> i < 5)
                .collect(Collectors.toUnmodifiableList());

        Assertions.assertThatThrownBy(() -> result.add(5))
                .isInstanceOf(UnsupportedOperationException.class);

    }

    @Test
    void collectorsUnmodifiableSet() {

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);

        Set<Integer> result = stream.filter(i -> i < 5)
                .collect(Collectors.toUnmodifiableSet());

        Assertions.assertThatThrownBy(() -> result.add(5))
                .isInstanceOf(UnsupportedOperationException.class);

    }

    @Test
    void collectorsUnmodifiableMap() {

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);

        Map<String, Integer> result = stream.filter(i -> i < 5)
                .collect(Collectors.toUnmodifiableMap(String::valueOf, i -> i));

        Assertions.assertThatThrownBy(() -> result.put("5", 5))
                .isInstanceOf(UnsupportedOperationException.class);

    }
}
