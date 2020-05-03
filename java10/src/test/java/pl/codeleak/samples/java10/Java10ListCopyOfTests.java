package pl.codeleak.samples.java10;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Java10ListCopyOfTests {

    @Test
    void copyOfArrayList() {
        var list = new ArrayList<String>();
        list.add("one");
        list.add("two");
        list.add("three");

        List<String> copyOfList = List.copyOf(list);

        list.add("four");

        // the copy is not modified when the source list is
        assertThat(copyOfList).containsExactly("one", "two", "three");

        assertThatThrownBy(() -> copyOfList.add("five"))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @Test
    void copyOfHashSet() {
        var set = new HashSet<String>();
        set.add("one");
        set.add("two");
        set.add("three");

        List<String> copyOfList = List.copyOf(set);
        assertThat(copyOfList).containsExactly("one", "two", "three");
    }
}
