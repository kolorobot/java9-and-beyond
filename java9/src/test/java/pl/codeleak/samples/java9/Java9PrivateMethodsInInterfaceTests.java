package pl.codeleak.samples.java9;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Java 9 - Private methods in interfaces")
class Java9PrivateMethodsInInterfaceTests {

    @Test
    void java9Interfaces() {
        StringProcessor stringProcessor = String::trim;
        String result = stringProcessor.parseAndCapitalize("  demo  ");
        assertThat(result).isEqualTo("DEMO");
    }
}


