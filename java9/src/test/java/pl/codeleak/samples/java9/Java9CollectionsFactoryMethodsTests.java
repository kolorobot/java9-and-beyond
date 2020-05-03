package pl.codeleak.samples.java9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Java 9 - Factory Methods for Collections")
class Java9CollectionsFactoryMethodsTests {

    @Test
    void createUnmodifiableSet() {
        // arrange
        Set<String> strings = new HashSet<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("four");
        strings.add("five");

        Set<String> stringsUnmodifiable = Collections.unmodifiableSet(strings);

        assertThat(stringsUnmodifiable).contains("one", "two", "three", "four", "five");
        // assert that modifying the list throws and exception
        assertThrows(UnsupportedOperationException.class, () -> stringsUnmodifiable.add("four"));
    }

    @Test
    void createImmutableSetJava9() {
        Set<String> strings = Set.of("one", "two", "three", "four", "five");
        // assert
        assertThat(strings).contains("one", "two", "three", "four", "five");
        assertThrows(UnsupportedOperationException.class, () -> strings.add("four"));
    }

    @Test
    void createUnmodifiableList() {
        // arrange
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        List<Integer> numbersUnmodifiable = Collections.unmodifiableList(numbers);

        // assert
        assertThat(numbersUnmodifiable).contains(1, 2, 3, 4, 5);
        assertThrows(UnsupportedOperationException.class, () -> numbersUnmodifiable.add(6));
    }

    @Test
    void createImmutableListJava9() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        // assert
        assertThat(numbers).contains(1, 2, 3, 4, 5);
        assertThrows(UnsupportedOperationException.class, () -> numbers.add(6));
    }

    @Test
    void createUnmodifiableMap() {
        // arrange
        Map<Integer, String> numbers = new HashMap<>();
        numbers.put(1, "one");
        numbers.put(2, "two");
        numbers.put(3, "three");
        numbers.put(4, "four");
        numbers.put(5, "five");

        Map<Integer, String> numbersUnmodifiable = Collections.unmodifiableMap(numbers);

        // assert
        assertThat(numbersUnmodifiable)
                .containsOnlyKeys(1, 2, 3, 4, 5)
                .containsValues("one", "two", "three", "four", "five");

        assertThrows(UnsupportedOperationException.class, () -> numbersUnmodifiable.put(6, "six"));
    }

    @Test
    void createUnmodifiableMapJava9() {
        Map<Integer, String> numbers = Map.of(1, "one", 2, "two", 3, "three", 4, "four", 5, "five");

        // assert
        assertThat(numbers)
                .containsOnlyKeys(1, 2, 3, 4, 5)
                .containsValues("one", "two", "three", "four", "five");

        assertThrows(UnsupportedOperationException.class, () -> numbers.put(6, "six"));
    }
}
