package pl.codeleak.samples.java12;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

class Java12FilesMismatchTests {

    @Test
    void mismatch1() throws IOException {
        Path path = Path.of("src", "test", "resources", "file1.txt");

        var result = Files.mismatch(path, path);

        assertThat(result).isEqualTo(-1);
    }

    @Test
    void mismatch2() throws IOException {
        Path path1 = Path.of("src", "test", "resources", "file1.txt");
        Path path2 = Path.of("src", "test", "resources", "file2.txt");

        var result = Files.mismatch(path1, path2);

        assertThat(result).isEqualTo(5);
    }

    @Test
    void mismatch3() throws IOException {
        Path path1 = Path.of("src", "test", "resources", "file3.txt");
        Path path2 = Path.of("src", "test", "resources", "file4.txt");

        var result = Files.mismatch(path1, path2);

        assertThat(result).isEqualTo(8);
    }
}
