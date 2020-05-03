package pl.codeleak.samples.java11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;


class Java11FilesTests {

    @TempDir
    Path tmpDir;

    @Test
    void writeAndReadString() throws IOException {
        Path newFile = tmpDir.resolve("tmp.txt");

        Files.writeString(newFile, "Demo");
        assertThat("Demo").isEqualTo(Files.readString(newFile));
    }

    @Test
    void isSameFile() throws IOException {
        Path newFile1 = tmpDir.resolve("tmp.txt");
        Path newFile2 = tmpDir.resolve("tmp.txt");
        Files.writeString(newFile1, "Demo");
        Files.writeString(newFile2, "Demo");

        assertThat(Files.isSameFile(newFile1, newFile2)).isTrue();
    }
}
