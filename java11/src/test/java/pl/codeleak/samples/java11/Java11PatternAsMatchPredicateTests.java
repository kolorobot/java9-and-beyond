package pl.codeleak.samples.java11;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class Java11PatternAsMatchPredicateTests {

    @Test
    void asMatchPredicate() {
        Pattern pattern = Pattern.compile(".*[0-9]+.*");

        Predicate<String> predicate = pattern.asMatchPredicate();

        String[] strings = new String[]{"abc", "42", "C-41", "X"};

        List<String> containingNumbers = Arrays.stream(strings).filter(predicate).collect(Collectors.toList());

        assertThat(containingNumbers).containsExactly("42", "C-41");

    }
}
