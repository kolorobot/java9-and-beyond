package pl.codeleak.samplesjava13;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Java13TextBlockTests {

    @Test
    void textBlock() {
        var str = """
                <html>
                    <body>
                        <p>Java 13 Text Block</p>
                    </body>
                </html>
                """;

        assertThat(str).contains("<p>Java 13 Text Block</p>");
    }

    @Test
    void formattedTextBlockWithStringFormatted() {
        var str = """
                <html>
                    <body>
                        <p>%s</p>
                    </body>
                </html>
                """.formatted("Text Blocks with String::formatted");

        assertThat(str).contains("<p>Text Blocks with String::formatted</p>");

    }

    @Test
    void formattedTextBlockWithStringReplace() {
        var str = """
                <html>
                    <body>
                        <p>$string</p>
                    </body>
                </html>
                """.replace("$string", "Text Blocks with String::replace");

        assertThat(str).contains("<p>Text Blocks with String::replace</p>");

    }
}
