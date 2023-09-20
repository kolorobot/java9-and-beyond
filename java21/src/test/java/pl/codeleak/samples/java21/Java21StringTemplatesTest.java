package pl.codeleak.samples.java21;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

class Java21StringTemplatesTest {
    @Test
    void stringTemplates() {
        String title = "My Web Page";
        String text = "Hello, world";

        String html = STR. """
        <html>
          <head>
            <title>\{ title }</title>
          </head>
          <body>
            <p>\{ "Time is: " + DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalTime.now()) }</p>
          </body>
        </html>
        """ ;

        Assertions.assertTrue(html.contains(title));
        Assertions.assertTrue(html.contains(DateTimeFormatter.ofPattern("HH:mm:ss").format(LocalTime.now())));


    }
}
