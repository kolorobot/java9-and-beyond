package pl.codeleak.samples.java21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.SequencedCollection;

class Java21SequencedCollectionTest {
    @Test
    void firstAndLasInList() {
        SequencedCollection<Integer> list = List.of(1, 2, 3, 5, 42);

        Assertions.assertEquals(1, list.getFirst());
        Assertions.assertEquals(42, list.getLast());
    }

    @Test
    void reverseList() {
        SequencedCollection<Integer> list = List.of(1, 2, 3);
        Assertions.assertEquals(List.of(3, 2, 1), list.reversed());
    }
}
